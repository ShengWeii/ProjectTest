package com.tga105.forum.Controller;

import com.tga105.forum.Enity.ArticleEntity;
import com.tga105.forum.Enity.ReplyEnity;
import com.tga105.forum.Enity.User;
import com.tga105.forum.Service.ArticleService;
import com.tga105.forum.Service.ReplyService;
import com.tga105.forum.Service.UserService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ReplyController {

//    @GetMapping("/addReply")
//    public String addReply(@RequestParam("replycontext") String context,
//                           final RedirectAttributes redirectAttributes){
//        System.out.println(context);
//
//
//        return "forumRead";
//    }

    @Autowired
    ArticleService articleService;

    @Autowired
    ReplyService replyService;

    @Autowired
    UserService userService;


    @GetMapping("/comments")
    public String add(@RequestParam("replycontext") String context,
                    @RequestParam("articleid") Integer id){

        ArticleEntity articleEntity=articleService.findById(id);
        ReplyEnity replyEnity=new ReplyEnity();
        replyEnity.setReplycontext(context);
        replyEnity.setArticleEntity(articleEntity);
        User user =userService.find(2);
        replyEnity.setUser(user);
        replyService.add(replyEnity);

        return "redirect:/forum";

//       測試聯表
//        String a=replyEnity.getArticleEntity().getArticlecontext();
//        System.out.println(a);
    }


}
