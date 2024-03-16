package com.myBlog.myBlog.service;

import com.myBlog.myBlog.payLoad.PostDto;

import java.util.List;

public interface PostService {
   public PostDto createDto(PostDto postDto);

      public PostDto getById(int id);

    List<PostDto> getAll(int pageNo, int pageSize, String sortBY, String sortDir);
}
