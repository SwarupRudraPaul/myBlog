package com.myBlog.myBlog.service;

import com.myBlog.myBlog.payLoad.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, int postId);

    void deleteComment(int id);

    CommentDto updateComment(int id,int postId, CommentDto commentDto);
}
