package edu.miu.cs544.blog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Blog")
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class BlogPost {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    private Boolean published;

    @Column(name = "views")
    private int viewCount;

    @Column(name = "comments")
    private int commentCount;

    public BlogPost() {
    }

    public BlogPost(String title, String content, Boolean published, int viewCount, int commentCount) {
        this.title = title;
        this.content = content;
        this.published = published;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
