package com.robert.fullstack.exposition.picture.visibility;

import com.robert.fullstack.application.picture.visibility.HidePicture;
import com.robert.fullstack.application.picture.visibility.UnhidePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image-visibility")
public class ImageVisibilityResource {

    @Autowired
    private HidePicture hidePicture;
    @Autowired
    private UnhidePicture unhidePicture;


    @RequestMapping(value = "/hide/{imageId}", method = RequestMethod.POST)
    public ResponseEntity hideImage(@PathVariable(value = "imageId") String imageId) {
        hidePicture.hide(imageId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/unhide/{imageId}", method = RequestMethod.POST)
    public ResponseEntity unhideImage(@PathVariable(value = "imageId") String imageId) {
        unhidePicture.unhide(imageId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
