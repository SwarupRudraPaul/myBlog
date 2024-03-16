package com.myBlog.myBlog.payLoad;

import lombok.Data;

@Data

public class CommentDto {
    private int id;

    private String commentText;

    private String email;
}
