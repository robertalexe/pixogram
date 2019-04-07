package com.robert.fullstack.exposition.picture;

import com.robert.fullstack.application.picture.ConsultPictureMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/download-image-metadata")
@CrossOrigin(origins = "*")
public class DownloadPictureMetadataResource {

    @Autowired
    private ConsultPictureMetadata consultPictureMetadata;

    @RequestMapping(value = "/{imageId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PictureMetadataRepresentation> getImage(@PathVariable(value = "imageId") String imageId) {
        PictureMetadataRepresentation representation = new PictureMetadataRepresentation(consultPictureMetadata.getPictureMetadata(imageId));
        return new ResponseEntity<>(representation, HttpStatus.OK);
    }
}
