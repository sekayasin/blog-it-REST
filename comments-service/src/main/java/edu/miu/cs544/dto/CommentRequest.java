package edu.miu.cs544.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class CommentRequest {
    @NotBlank
    private String content;
    @Positive
    private Long post;
    @Positive
    private Long user;
}
