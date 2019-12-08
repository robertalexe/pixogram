package com.robert.fullstack.application.picture;

import com.robert.fullstack.domain.ddd.DDD;
import org.springframework.web.multipart.MultipartFile;

@DDD.ValueObject
public class StorePictureCommand {

    private MultipartFile multipart;
    private String pictureName;
    private boolean sharedToFollowers;
    private String pictureDescription;

    public StorePictureCommand(MultipartFile multipart, String pictureName, boolean sharedToFollowers, String pictureDescription) {
        this.multipart = multipart;
        this.pictureName = pictureName;
        this.sharedToFollowers = sharedToFollowers;
        this.pictureDescription = pictureDescription;
    }

    public MultipartFile getMultipart() {
        return multipart;
    }

    public String getPictureName() {
        return pictureName;
    }

    public boolean isSharedToFollowers() {
        return sharedToFollowers;
    }

    public String getPictureDescription() {
        return pictureDescription;
    }
}
