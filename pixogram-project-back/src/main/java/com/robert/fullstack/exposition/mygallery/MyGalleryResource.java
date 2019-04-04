package com.robert.fullstack.exposition.mygallery;

import com.robert.fullstack.application.mygallery.ConsultMyGallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/my-gallery")
public class MyGalleryResource {

    @Autowired
    private ConsultMyGallery consultMyGallery;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<String>> getMyImageIds() {
        Set<String> allPictureIds = consultMyGallery.getAllImageIds();
        return new ResponseEntity<>(allPictureIds, HttpStatus.OK);
    }
}
