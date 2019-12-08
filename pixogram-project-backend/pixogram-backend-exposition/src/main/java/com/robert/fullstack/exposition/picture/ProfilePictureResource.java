package com.robert.fullstack.exposition.picture;

import com.robert.fullstack.application.picture.DownloadPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
