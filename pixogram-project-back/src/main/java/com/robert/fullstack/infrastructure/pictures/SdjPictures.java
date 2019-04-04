package com.robert.fullstack.infrastructure.pictures;

import com.robert.fullstack.config.FileStorageProperties;
import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.ImagePath;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.PictureComment;
import com.robert.fullstack.domain.pictures.Pictures;
import com.robert.fullstack.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
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
    public Picture storePictureForCurrentUser(MultipartFile multipartFile, String name, boolean sharedToFollowers, String description) {
        String uniqueIdentifier = UUID.randomUUID().toString();
        // Normalize file name
        Picture newPicture = null;
        try {
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(uniqueIdentifier);
            Files.copy(multipartFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            newPicture = new Picture(
                    uniqueIdentifier,
                    this.identitySupplier.get().getUsername(),
                    new ImagePath(targetLocation.toAbsolutePath().toString()),
                    name,
                    multipartFile.getOriginalFilename(),
                    description,
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
    public Picture getPicture(String pictureId) {
        return picturesSdj.getOne(pictureId);
    }

    @Override
    public Set<Picture> getPicturesForUser(String username) {
        List<Picture> allPicturesForUser = picturesSdj.findPicturesByOwnerEmail(username);
        return new HashSet<>(allPicturesForUser);
    }

    @Override
    public void addComment(String pictureId, String comment) {
        Picture picture = picturesSdj.getOne(pictureId);
        picture.addComment(
                new PictureComment(
                        UUID.randomUUID().toString(),
                        pictureId,
                        comment,
                        now()
                )
        );
        picturesSdj.saveAndFlush(picture);
    }

    @Override
    public void addLike(String pictureId) {
        Picture picture = picturesSdj.getOne(pictureId);
        picture.addLike(identitySupplier.get().getUsername());
        picturesSdj.saveAndFlush(picture);
    }

    @Override
    public void removeLike(String pictureId) {
        Picture picture = picturesSdj.getOne(pictureId);
        picture.removeLike(identitySupplier.get().getUsername());
        picturesSdj.saveAndFlush(picture);
    }
}
