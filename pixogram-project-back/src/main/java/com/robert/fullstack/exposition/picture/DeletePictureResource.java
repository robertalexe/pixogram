package com.robert.fullstack.exposition.picture;

import com.robert.fullstack.application.picture.DeletePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delete-image")
public class DeletePictureResource {

    @Autowired
    private DeletePicture deletePicture;

    @RequestMapping(value = "/{imageId}", method = RequestMethod.POST)
    public ResponseEntity deleteImage(@PathVariable(value = "imageId") String imageId) {
        deletePicture.delete(imageId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
