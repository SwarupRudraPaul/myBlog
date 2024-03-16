package com.myBlog.myBlog.repository;

import com.myBlog.myBlog.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {
}
