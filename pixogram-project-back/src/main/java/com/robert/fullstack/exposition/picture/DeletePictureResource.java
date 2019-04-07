package com.robert.fullstack.exposition.picture;

import com.robert.fullstack.application.picture.DeletePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delete-image")
@CrossOrigin(origins = "*")
public class DeletePictureResource {

    @Autowired
    private DeletePicture deletePicture;

    @RequestMapping(value = "/{imageId}", method = RequestMethod.POST)
    public ResponseEntity deleteImage(@PathVariable(value = "imageId") String imageId) {
        deletePicture.delete(imageId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
