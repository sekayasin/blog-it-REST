package edu.miu.cs544;

public class CommentResponse {
    private String content;

    public CommentResponse() {  }

    public CommentResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
