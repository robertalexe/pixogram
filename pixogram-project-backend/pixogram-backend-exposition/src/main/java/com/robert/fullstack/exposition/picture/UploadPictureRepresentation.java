package com.robert.fullstack.exposition.picture;

import com.robert.fullstack.application.picture.StorePictureCommand;
import org.springframework.web.multipart.MultipartFile;

public class UploadPictureRepresentation {

    public MultipartFile file;
    public String pictureName;
    public boolean sharedToFollowers;
    public String pictureDescription;

    public StorePictureCommand toStorePictureCommand() {
        return new StorePictureCommand(this.file, this.pictureName, this.sharedToFollowers, this.pictureDescription);
    }
}
