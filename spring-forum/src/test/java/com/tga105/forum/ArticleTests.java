package com.tga105.forum;

import com.tga105.forum.Enity.ArticleEntity;
import com.tga105.forum.Enity.ReplyEnity;
import com.tga105.forum.Service.ArticleService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class ArticleTests {

    @Autowired
    ArticleService articleService;

//    @Test
//    public void addArticle(){
//        ArticleEntity articleEntity=new ArticleEntity();
//        articleEntity.setUserid(1);
//        articleEntity.setArticletypeid(1);
//        articleEntity.setArticletitle("哈利波特");
//        articleEntity.setArticlecontext("好看");
//
//
//        ReplyEnity replyEnity1=new ReplyEnity("確定好看嗎");
//        ReplyEnity replyEnity2=new ReplyEnity("難看");
//
//
//        articleEntity.addReply(replyEnity1);
//        articleEntity.addReply(replyEnity2);
//
//
//        articleService.add(articleEntity);
//
//    }

//    @Test
//    public  void find(){
//        ArticleEntity articleEntity=articleService.findById(60);
//        System.out.println(articleEntity);
//    }

    @Test
    public void delete(){
        articleService.delete(64);
    }

}
