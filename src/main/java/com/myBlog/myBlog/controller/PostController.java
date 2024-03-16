package com.myBlog.myBlog.controller;

import com.myBlog.myBlog.payLoad.PostDto;
import com.myBlog.myBlog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PreAuthorize("hasRole('ADMIN')")

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createDto(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping("/particular")
    public ResponseEntity<PostDto> getById(@RequestParam int id){
        PostDto byId = postService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);

    }

    //http://localhost:8080/api/posts?pageNo=0&pageSize=2&sortBY=title&sortDir=ASC
    @GetMapping
    public List<PostDto> getAll(
            @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "1") int pageSize,
            @RequestParam(name = "sortBY", required = false, defaultValue = "id")String sortBY,
            @RequestParam(name = "sortDir", required = false, defaultValue = "id")String sortDir
    ){
        List<PostDto> postDtoList = postService.getAll(pageNo,pageSize,sortBY,sortDir);
        return postDtoList;
    }
}
