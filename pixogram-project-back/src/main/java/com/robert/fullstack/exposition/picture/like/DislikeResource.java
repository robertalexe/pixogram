package com.robert.fullstack.exposition.picture.like;

import com.robert.fullstack.application.picture.like.RemoveLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dislike")
public class DislikeResource {

    @Autowired
    private RemoveLike removeLike;

    @RequestMapping(value = "/{imageId}", method = RequestMethod.POST)
    public ResponseEntity dislikeImage(
            @PathVariable(value = "imageId") String imageId
    ) {
        removeLike.removeLike(imageId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
