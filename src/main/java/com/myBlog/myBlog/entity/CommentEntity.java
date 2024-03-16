package com.myBlog.myBlog.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
    @Table(name = "comments")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class CommentEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String commentText;

        private String email;

        @ManyToOne
        @JoinColumn(name = "post_id")
        private Post post;

        // Constructors, getters, and setters
    }


