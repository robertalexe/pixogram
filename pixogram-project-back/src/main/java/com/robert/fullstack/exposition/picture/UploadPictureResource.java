package com.robert.fullstack.exposition.picture;

import com.robert.fullstack.application.picture.StorePicture;
import com.robert.fullstack.exposition.SingleValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload-image")
public class UploadPictureResource {

    @Autowired
    private StorePicture storePicture;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity uploadPicture(@RequestParam("file") MultipartFile file) {
        storePicture.storePicture(file);
        return new ResponseEntity(HttpStatus.OK);
    }
}
