package com.robert.fullstack.application.picture;

import com.robert.fullstack.domain.DDD;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@DDD.ValueObject @Getter @AllArgsConstructor
public class StorePictureCommand {

    private MultipartFile multipart;
    private String pictureName;
    private boolean sharedToFollowers;
    private String pictureDescription;
}
