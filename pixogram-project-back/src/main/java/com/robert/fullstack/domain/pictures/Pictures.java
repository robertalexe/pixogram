package com.robert.fullstack.domain.pictures;

import com.robert.fullstack.domain.user.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface Pictures {

    Set<Pictures> findPicturesForFollowings(User user);

    Picture storePictureForCurrentUser(MultipartFile multipartFile);
}
