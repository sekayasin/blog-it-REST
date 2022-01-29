package edu.miu.cs544.dto;

import lombok.Data;

@Data
public class CommentRequest {
    private String content;
    private Long post;
    private Long user;
}
