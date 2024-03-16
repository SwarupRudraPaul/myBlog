package com.myBlog.myBlog.controller;

import com.myBlog.myBlog.payLoad.CommentDto;
import com.myBlog.myBlog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam int postId
            ){
        CommentDto comment = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    //http://loalhost:8080/api/comments/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable int id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment is Deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable int id,
            @PathVariable int postId,
            @RequestBody CommentDto commentDto
    ){
        CommentDto dto = commentService.updateComment(id,postId, commentDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
