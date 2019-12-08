package com.robert.fullstack.infra.pictures;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.pictures.*;
import com.robert.fullstack.domain.user.Email;
import com.robert.fullstack.domain.user.NameFragment;
import com.robert.fullstack.infra.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import static java.time.LocalDateTime.now;

@DDD.RepositoryImpl
@Service
public class SdjPictures implements Pictures {

    private final Path fileStorageLocation;
    @Autowired
    private IdentitySupplier identitySupplier;
    @Autowired
    private PicturesSdj picturesSdj;

    @Autowired
    public SdjPictures(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Override
    public Picture storePictureForCurrentUser(MultipartFile multipartFile, NameFragment name, boolean sharedToFollowers, Description description) {
        String uniqueIdentifier = UUID.randomUUID().toString();
        // Normalize file name
        Picture newPicture = null;
        try {
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(uniqueIdentifier);
            Files.copy(multipartFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            newPicture = new Picture(
                    new PictureId(uniqueIdentifier),
                    new Email(this.identitySupplier.get().getUsername()),
                    new ImagePath(targetLocation.toAbsolutePath().toString()),
                    new PictureInfo(name, new NameFragment(multipartFile.getOriginalFilename()), description),
                    sharedToFollowers,
                    now(),
                    Collections.emptySet(),
                    Collections.emptySet()
            );
            this.picturesSdj.save(newPicture);
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + multipartFile.getName() + ". Please try again!", ex);
        }
        return newPicture;
    }

    @Override
    public Picture getPicture(PictureId pictureId) {
        return picturesSdj.getOne(pictureId);
    }

    @Override
    public Set<Picture> getPicturesForUser(Email username, boolean sharedToFollowers) {
        List<Picture> allPicturesForUser = picturesSdj.findPicturesByOwnerEmailAndSharedToFollowers(username, sharedToFollowers);
        return new HashSet<>(allPicturesForUser);
    }

    @Override
    public Set<Picture> getPicturesForMyGallery() {
        List<Picture> allPicturesForUser = picturesSdj.findPicturesByOwnerEmail(new Email(identitySupplier.get().getUsername()));
        return new HashSet<>(allPicturesForUser);
    }

    @Override
    public void addComment(PictureId pictureId, Comment comment) {
        Picture picture = picturesSdj.getOne(pictureId);
        picture.addComment(
                new PictureComment(
                        pictureId,
                        comment,
                        now()
                )
        );
        picturesSdj.saveAndFlush(picture);
    }

    @Override
    public void addLike(PictureId pictureId) {
        Picture picture = picturesSdj.getOne(pictureId);
        picture.addLike(new Email(identitySupplier.get().getUsername()));
        picturesSdj.saveAndFlush(picture);
    }

    @Override
    public void removeLike(PictureId pictureId) {
        Picture picture = picturesSdj.getOne(pictureId);
        picture.removeLike(new Email(identitySupplier.get().getUsername()));
        picturesSdj.saveAndFlush(picture);
    }

    @Override
    public void rename(NameFragment newImageName, PictureId pictureId) {
        Picture picture = picturesSdj.getOne(pictureId);
        picture.rename(newImageName);
        picturesSdj.saveAndFlush(picture);
    }

    @Override
    public void delete(PictureId pictureId) {
        picturesSdj.deleteById(pictureId);
        picturesSdj.flush();
    }

    @Override
    public void hide(PictureId pictureId) {
        Picture picture = picturesSdj.getOne(pictureId);
        picture.hidePicture();
        picturesSdj.saveAndFlush(picture);
    }

    @Override
    public void unhide(PictureId pictureId) {
        Picture picture = picturesSdj.getOne(pictureId);
        picture.unhidePicture();
        picturesSdj.saveAndFlush(picture);
    }
}
