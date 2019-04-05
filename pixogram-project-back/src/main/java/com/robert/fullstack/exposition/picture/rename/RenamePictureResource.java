package com.robert.fullstack.exposition.picture.rename;

import com.robert.fullstack.application.picture.RenamePicture;
import com.robert.fullstack.application.picture.StorePictureCommand;
import com.robert.fullstack.domain.pictures.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/rename")
public class RenamePictureResource {

    @Autowired
    private RenamePicture renamePicture;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity uploadPicture(@RequestParam("pictureName") String pictureName, @RequestParam("pictureId") String pictureId){
        renamePicture.rename(pictureName, pictureId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
