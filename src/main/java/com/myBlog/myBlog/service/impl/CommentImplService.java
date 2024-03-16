package com.myBlog.myBlog.service.impl;

import com.myBlog.myBlog.entity.CommentEntity;
import com.myBlog.myBlog.entity.Post;
import com.myBlog.myBlog.exception.ResourceNotFoundException;
import com.myBlog.myBlog.payLoad.CommentDto;
import com.myBlog.myBlog.repository.CommentRepository;
import com.myBlog.myBlog.repository.PostRepository;
import com.myBlog.myBlog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentImplService implements CommentService {

    private PostRepository postRepository;

    private CommentRepository commentRepository;

    private ModelMapper modelMapper;

    public CommentImplService(PostRepository postRepository, CommentRepository commentRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, int postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("PostNotFoundWIthId"+postId)
        );
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setEmail(commentDto.getEmail());
        commentEntity.setCommentText(commentDto.getCommentText());
        commentEntity.setPost(post);

        CommentEntity save = commentRepository.save(commentEntity);

        CommentDto dto = new CommentDto();
        dto.setId(save.getId());
        dto.setEmail(save.getEmail());
        dto.setCommentText(save.getCommentText());
        return dto;
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(int id,int postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Comment nor found for id:" + postId)
        );
        CommentEntity commentEntity = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment nor found for id:" + id)
        );

        CommentEntity ce = mapToEntity(commentDto);
        ce.setId(commentEntity.getId());
        ce.setPost(post);
        CommentEntity saved = commentRepository.save(ce);
        return mapToDto(saved);

    }

    CommentDto mapToDto(CommentEntity commentEntity){
        CommentDto dto = modelMapper.map(commentEntity, CommentDto.class);
        return dto;
    }

    CommentEntity mapToEntity(CommentDto commentDto){
        CommentEntity entity = modelMapper.map(commentDto, CommentEntity.class);
        return entity;
    }
}
