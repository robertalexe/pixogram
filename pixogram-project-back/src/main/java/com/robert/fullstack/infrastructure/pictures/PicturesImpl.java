package com.robert.fullstack.infrastructure.pictures;

import com.robert.fullstack.config.FileStorageProperties;
import com.robert.fullstack.domain.DDD;
import com.robert.fullstack.domain.IdentitySupplier;
import com.robert.fullstack.domain.ImagePath;
import com.robert.fullstack.domain.pictures.Picture;
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
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@DDD.RepositoryImpl
@Service
public class PicturesImpl implements Pictures {

    private final Path fileStorageLocation;
    @Autowired
    private IdentitySupplier identitySupplier;

    @Autowired
    public PicturesImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Override
    public Picture storePictureForCurrentUser(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Picture newPicture = null;
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            newPicture = new Picture(
                    UUID.randomUUID().toString(),
                    this.identitySupplier.get().getUsername(),
                    new ImagePath(targetLocation.toAbsolutePath().toString()),
                    file.getName(),
                    file.getContentType(),
                    "description",
                    false,
                    LocalDateTime.now(),
                    0,
                    Collections.emptySet()
            );
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
        return newPicture;
    }


    @Override
    public Set<Pictures> findPicturesForFollowings(User user) {
        return null;
    }

}
