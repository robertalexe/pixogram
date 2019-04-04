package com.robert.fullstack.infrastructure.pictures;

import com.robert.fullstack.domain.pictures.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicturesSdj extends JpaRepository<Picture, String> {

    public List<Picture> findPicturesByOwnerEmail(String ownerEmail);
}
