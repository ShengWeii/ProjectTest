package com.tga105.forum.Enity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Integer articleid;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;

    @Column(name ="article_title")
    private String articletitle;

    @Column(name ="article_context")
    private String articlecontext;
    @Column(name ="post_datetime", nullable = false,columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private java.util.Date postdatetime;


    @Column(name = "update_datetime",nullable = false,columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private java.util.Date updatetime;

    @ManyToOne
    @JoinColumn(name="articletypeid")
    private  ArticleTypeEntity articleTypeEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "articleEntity")
    private List<ReplyEnity> replyEnitySet;

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle;
    }

    public String getArticlecontext() {
        return articlecontext;
    }

    public void setArticlecontext(String articlecontext) {
        this.articlecontext = articlecontext;
    }

    public Date getPostdatetime() {
        return postdatetime;
    }

    public void setPostdatetime(Date postdatetime) {
        this.postdatetime = postdatetime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public ArticleTypeEntity getArticleTypeEntity() {
        return articleTypeEntity;
    }

    public void setArticleTypeEntity(ArticleTypeEntity articleTypeEntity) {
        this.articleTypeEntity = articleTypeEntity;
    }

    public List<ReplyEnity> getReplyEnitySet() {
        return replyEnitySet;
    }

    public void setReplyEnitySet(List<ReplyEnity> replyEnitySet) {
        this.replyEnitySet = replyEnitySet;
    }


    //    public List<ReplyEnity> getReplyEnityList() {
//        return replyEnityList;
//    }

//    public void setReplyEnityList(List<ReplyEnity> replyEnityList) {
//        this.replyEnityList = replyEnityList;
//    }



//    @OneToMany(mappedBy = "articleEntity", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
//    private List<ReplyEnity> replyEnityList=new ArrayList<>();

//    public void addReply(ReplyEnity replyEnity){
//        replyEnity.setArticleEntity(this);
//        replyEnityList.add(replyEnity);
//    }



//    @Override
//    public String toString() {
//        return "ArticleEntity{" +
//                "replyEnitySet=" + replyEnitySet +
//                '}';
//    }
}
