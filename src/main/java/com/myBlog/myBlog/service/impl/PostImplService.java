package com.myBlog.myBlog.service.impl;

import com.myBlog.myBlog.entity.Post;
import com.myBlog.myBlog.exception.ResourceNotFoundException;
import com.myBlog.myBlog.payLoad.PostDto;
import com.myBlog.myBlog.repository.PostRepository;
import com.myBlog.myBlog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostImplService implements PostService {
    private PostRepository postRepository;

    private ModelMapper modelMapper;

    public PostImplService(PostRepository postRepository,ModelMapper modelMapper) {

        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createDto(PostDto postDto) {

        Post post = mapToEntity(postDto);
        Post save= postRepository.save(post);

        PostDto dto = mapToDto(save);
        return dto;
    }

    @Override
    public PostDto getById(int id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Invalid Id!!!")
        );

        PostDto dto = new PostDto();

        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    @Override
    public List<PostDto> getAll(int pageNo, int pageSize, String sortBY, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? Sort.by(sortBY).ascending() : Sort.by(sortBY).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Post> getAll = postRepository.findAll(pageable);
        List<Post> content = getAll.getContent();

        List<PostDto> collect = content.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return collect;
    }

    PostDto mapToDto(Post post){
        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }

    Post mapToEntity(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }
}
