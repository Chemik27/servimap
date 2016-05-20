package com.tpfinal.service;

import com.tpfinal.domain.Comment;
import com.tpfinal.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    ICommentRepository commentRepository;

    public List<Comment> findByToUser(Long idUser){
        return commentRepository.findByToUser(idUser);
    }
}
