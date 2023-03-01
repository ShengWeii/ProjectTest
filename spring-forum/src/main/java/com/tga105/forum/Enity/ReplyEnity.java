package com.tga105.forum.Enity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ReplyEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reply_id")
    private Integer replyid;

    @Column(name="reply_context",nullable = false)
    private String replycontext;


    @Column(name="reply_datetime",nullable = false,columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date replydatetime;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="articleid")
    private  ArticleEntity articleEntity;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;


    public  ReplyEnity(){

    };
    public ReplyEnity(String replycontext) {
        this.replycontext = replycontext;
    }

    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    public String getReplycontext() {
        return replycontext;
    }

    public void setReplycontext(String replycontext) {
        this.replycontext = replycontext;
    }

    public Date getReplydatetime() {
        return replydatetime;
    }

    public void setReplydatetime(Date replydatetime) {
        this.replydatetime = replydatetime;
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
