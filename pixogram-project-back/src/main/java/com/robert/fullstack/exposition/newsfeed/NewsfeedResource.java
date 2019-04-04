package com.robert.fullstack.exposition.newsfeed;

import com.netflix.discovery.converters.Auto;
import com.robert.fullstack.application.newsfeed.ConsultNewsfeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/newsfeed")
public class NewsfeedResource {

    @Autowired
    private ConsultNewsfeed consultNewsfeed;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<String>> getNewsfeedImageIds() {
        Set<String> allPictureIds = consultNewsfeed.getAllImageIdsForNewsfeed();
        return new ResponseEntity<>(allPictureIds, HttpStatus.OK);
    }
}
