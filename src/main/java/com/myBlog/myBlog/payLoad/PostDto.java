package com.myBlog.myBlog.payLoad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private int id;
    private String title;
    private String description;
    private String content;
}
