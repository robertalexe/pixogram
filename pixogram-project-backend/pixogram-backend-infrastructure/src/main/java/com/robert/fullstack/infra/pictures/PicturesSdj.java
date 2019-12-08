package com.robert.fullstack.infra.pictures;

import com.robert.fullstack.domain.pictures.Picture;
import com.robert.fullstack.domain.pictures.PictureId;
import com.robert.fullstack.domain.user.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicturesSdj extends JpaRepository<Picture, PictureId> {

    List<Picture> findPicturesByOwnerEmail(Email ownerEmail);

    List<Picture> findPicturesByOwnerEmailAndSharedToFollowers(Email ownerEmail, boolean sharedToFollowers);
}
