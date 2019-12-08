package com.robert.fullstack.application.picture.comment;

import com.robert.fullstack.domain.ddd.DDD;
import com.robert.fullstack.domain.pictures.Comment;
import com.robert.fullstack.domain.pictures.PictureId;
import com.robert.fullstack.domain.pictures.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DDD.ApplicationService
@Service
@Transactional
public class AddComment {

    @Autowired
    private Pictures pictures;

    public void addComment(PictureId pictureId, Comment comment) {
        pictures.addComment(pictureId, comment);
    }
}
