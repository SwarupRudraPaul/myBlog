package com.myBlog.myBlog.service.impl;

import com.myBlog.myBlog.entity.Post;
import com.myBlog.myBlog.payLoad.PostDto;
import com.myBlog.myBlog.repository.PostRepository;
import com.myBlog.myBlog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostImplService implements PostService {
    private PostRepository postRepository;

    public PostImplService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createDto(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

       Post save= postRepository.save(post);

       PostDto dto = new PostDto();

        dto.setTitle(save.getTitle());
        dto.setDescription(save.getDescription());
        dto.setContent(save.getContent());
        return dto;
    }
}
