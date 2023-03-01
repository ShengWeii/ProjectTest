package com.tga105.forum.Enity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user-id")
    private Integer userid;

    @Column(name="user_name")
    private String username;

    @OneToMany(mappedBy = "user")
    private List<ReplyEnity> replyEnityList;

    @OneToMany(mappedBy = "user")
    private  List<ArticleEntity> articleEntities;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ReplyEnity> getReplyEnityList() {
        return replyEnityList;
    }

    public void setReplyEnityList(List<ReplyEnity> replyEnityList) {
        this.replyEnityList = replyEnityList;
    }

    public List<ArticleEntity> getArticleEntities() {
        return articleEntities;
    }

    public void setArticleEntities(List<ArticleEntity> articleEntities) {
        this.articleEntities = articleEntities;
    }
}
