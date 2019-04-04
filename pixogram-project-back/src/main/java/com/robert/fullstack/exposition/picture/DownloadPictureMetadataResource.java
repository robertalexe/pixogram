package com.robert.fullstack.exposition.picture;

import com.robert.fullstack.application.picture.ConsultPictureMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/download-image-metadata")
public class DownloadPictureMetadataResource {

    @Autowired
    private ConsultPictureMetadata consultPictureMetadata;

    @RequestMapping(value = "/{imageId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PictureMetadataRepresentation> getImage(@PathVariable(value = "imageId") String imageId) {
        PictureMetadataRepresentation representation = new PictureMetadataRepresentation(consultPictureMetadata.getPictureMetadata(imageId));
        return new ResponseEntity<>(representation, HttpStatus.OK);
    }
}
