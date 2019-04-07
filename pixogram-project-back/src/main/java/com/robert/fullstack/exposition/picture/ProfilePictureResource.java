package com.robert.fullstack.exposition.picture;

import com.netflix.discovery.converters.Auto;
import com.robert.fullstack.application.picture.DownloadPicture;
import com.robert.fullstack.exposition.SingleValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile-picture")
@CrossOrigin(origins = "*")
public class ProfilePictureResource {

    @Autowired
    private DownloadPicture downloadPicture;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getRandomProfilePicture() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        byte[] media = downloadPicture.downloadProfilePicture();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        return new ResponseEntity<>(media, headers, HttpStatus.OK);
    }
}
