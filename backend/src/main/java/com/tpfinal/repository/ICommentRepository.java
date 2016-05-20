package com.tpfinal.repository;

import com.tpfinal.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository  extends JpaRepository<Comment, Long>{

    public List<Comment> findByToUser(Long idUser);
}
