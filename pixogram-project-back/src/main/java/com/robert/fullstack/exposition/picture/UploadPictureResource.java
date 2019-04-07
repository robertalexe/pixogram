package com.robert.fullstack.exposition.picture;

import com.robert.fullstack.application.picture.StorePicture;
import com.robert.fullstack.application.picture.StorePictureCommand;
import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.exposition.SingleValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload-image")
@CrossOrigin(origins = "*")
public class UploadPictureResource {

    @Autowired
    private StorePicture storePicture;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> uploadPicture(@RequestParam("file") MultipartFile file,
                                        @RequestParam("pictureName") String pictureName,
                                        @RequestParam("pictureDescription") String pictureDescription,
                                        @RequestParam("shared") boolean shared
    ){
        Picture uploadedPicture = storePicture.storePicture(new StorePictureCommand(file, pictureName, shared, pictureDescription));
        return new ResponseEntity(uploadedPicture.getPictureId(), HttpStatus.OK);
    }
}
