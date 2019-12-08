package com.robert.fullstack.exposition.picture.like;

import com.robert.fullstack.application.picture.like.RemoveLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dislike")
@CrossOrigin(origins = "*")
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
