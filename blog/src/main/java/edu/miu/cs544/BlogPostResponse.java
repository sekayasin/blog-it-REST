package edu.miu.cs544;


import lombok.Data;

import java.util.List;

@Data
public class BlogPostResponse {
    private String title;
    private String content;
    private Boolean published;
    private int viewCount;
    private int commentCount;
    private List<CommentResponse> comments;
}
