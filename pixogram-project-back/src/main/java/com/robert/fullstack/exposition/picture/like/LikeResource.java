package com.robert.fullstack.exposition.picture.like;

import com.robert.fullstack.application.picture.like.AddLike;
import com.robert.fullstack.application.picture.like.ViewLikes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/like")
@CrossOrigin(origins = "*")
public class LikeResource {
    @Autowired
    private AddLike addLike;
    @Autowired
    private ViewLikes viewLikes;

    @RequestMapping(value = "/{imageId}", method = RequestMethod.POST)
    public ResponseEntity likeImage(
            @PathVariable(value = "imageId") String imageId
    ) {
        addLike.addLike(imageId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{imageId}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> allLikes(
            @PathVariable(value = "imageId") String imageId
    ) {
        return new ResponseEntity(viewLikes.allLikes(imageId), HttpStatus.OK);
    }
}
