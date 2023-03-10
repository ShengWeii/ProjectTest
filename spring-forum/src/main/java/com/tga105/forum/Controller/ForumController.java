package com.tga105.forum.Controller;

import com.tga105.forum.Enity.ArticleEntity;
import com.tga105.forum.Enity.ArticleTypeEntity;
import com.tga105.forum.Enity.ReplyEnity;
import com.tga105.forum.Enity.User;
import com.tga105.forum.Service.ArticleService;
import com.tga105.forum.Service.ArticleTypeService;
import com.tga105.forum.Service.ReplyService;
import com.tga105.forum.Service.UserService;
import jakarta.validation.Valid;
import jdk.jfr.Threshold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ForumController {
    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleTypeService articleTypeService;

    @Autowired
    ReplyService replyService;

    @Autowired
    UserService userService;

    @GetMapping("/read")
    public  String read(Model model){

        return  "forumRead";
    }

    @GetMapping("/read/{id}")
    public  String Read(@PathVariable Integer id,
                        Model model){
        ArticleEntity articleEntity = articleService.findById(id);
        User user=userService.find(2);

        if(articleEntity==null){
            articleEntity=new ArticleEntity();
        }

        List<ReplyEnity> list= articleEntity.getReplyEnitySet();
        articleEntity.setUser(user);
        User user1=articleEntity.getUser();

        model.addAttribute("articleEntity",articleEntity);
        model.addAttribute("lister",list);
        model.addAttribute("userr",user1);

        return "forumRead";
    }
    @RequestMapping("/forumPost")
    public  String create(Model model){
        model.addAttribute("articleEntity",new ArticleEntity());
        List<ArticleTypeEntity> articleEntityList=articleTypeService.findAll();
        model.addAttribute("articleall",articleEntityList);
        return "forumPost";
    }
    /*
    ??????Valid?????? ??????????????????Spring?????????????????????????????????????????????????????????????????????????????????
     */
    @PostMapping ("/create")
    public String create (final  RedirectAttributes redirectAttributes,
                          @RequestParam String articletitle,
                          @RequestParam String articlecontext,
                          @RequestParam(name="articletypeid") Integer typeid,
                                        Model  model){


        if("".equals(articletitle)){
            redirectAttributes.addFlashAttribute("errmsgs","?????????????????????");

            return  "redirect:/forumPost";
        }
        if ("".equals(articlecontext)){
            redirectAttributes.addFlashAttribute("errmsgs","?????????????????????");
            return  "redirect:/forumPost";
        }

        ArticleEntity articleEntity=new ArticleEntity();
        User user=userService.find(1);
        articleEntity.setArticlecontext(articlecontext);
        articleEntity.setArticletitle(articletitle);
        ArticleTypeEntity articleTypeEntity=articleTypeService.find(typeid);
        articleEntity.setArticleTypeEntity(articleTypeEntity);
        articleEntity.setUser(user);
//        System.out.println(user.getUserid());
//        articleEntity.setUserid(1);
        ArticleEntity articleEntity1=articleService.add(articleEntity);
        if(articleEntity1!=null){
           redirectAttributes.addFlashAttribute("success","<"+articleEntity1.getArticletitle()+">"+"???????????????");
        }

        return "redirect:/forum";
    }

    @PostMapping("/context")
    public  List<ArticleEntity> findByContext(@RequestParam String context){
        return  articleService.findByS(context);
    }

    /*
     ????????????????????????
     */
    @GetMapping("/forumSearch")
    public String pageSearch(Model model){

        return "forumSearch";
    }

    @PostMapping("/search")
    public String articleSearch(Model model,
                                @RequestParam("article_search") String key){

        if("".equals(key)){
            String errmsgs="??????????????????";
            model.addAttribute("errmsgs",errmsgs);
            return "forumSearch";
        }
        List<ArticleEntity> articleEntities=articleService.findByWords(key,key);
        if(articleEntities.isEmpty()){
            String errmsgs="???????????????????????????";
            model.addAttribute("errmsgs",errmsgs);
            return "forumSearch";
        }
        int count=articleEntities.size();
        String total="????????????????????????"+count+"?????????";
        model.addAttribute("total",total);
        model.addAttribute("articleEntities",articleEntities);
        return "forumSearch";
    }
    /*
    ?????????????????? ????????????????????????
    ???????????? SIze=5,??????JSON?????? ,????????????(2.26)
    ?????????????????????????????? page0???????????????
     */
    @ResponseBody
    @GetMapping("/findbypages")
    public Page<ArticleEntity> findAByPages(@RequestParam(defaultValue ="1") int page,
                                            @RequestParam(defaultValue = "3")int size){
        Sort sort = Sort.by(Sort.Direction.ASC,"articleid");
        return  articleService.findAllByPage(PageRequest.of(page,size,sort));
    }
    @RequestMapping("/forum")
    public String index(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "5") int size,
                                                         Model model){
        Sort sort = Sort.by(Sort.Direction.ASC,"articleid");
        Page<ArticleEntity> pages=articleService.findAllByPage(PageRequest.of(page,size,sort));
       // List<ArticleEntity> articleEntityList =articleService.findAll();
        model.addAttribute("page",pages);

        return  "forum";
    }

    @ResponseBody
    @GetMapping("/jpql")
    public List<ArticleEntity> findByJPQL(@RequestParam int length){
        return  articleService.findByJPQL(length);
    }
    @ResponseBody
    @GetMapping("/update")
    public int findByJPql(@RequestParam String articletitle,
                          @RequestParam String articlecontext,
                          @RequestParam Integer articleid){
        return  articleService.findByJPQL(articletitle,articlecontext,articleid);
    }
    @GetMapping("/index")
    public  String index(){


        return  "index";
    }


    @ResponseBody
    @GetMapping("/addtype")
    public  void  add(){
        ArticleEntity articleEntity= new ArticleEntity();

        ArticleTypeEntity articleTypeEntity=articleTypeService.find(3);

        articleEntity.setArticleTypeEntity(articleTypeEntity);

        articleEntity.setArticletitle("springboot");
        articleEntity.setArticlecontext("fun");
//       articleEntity.setUserid(1);

        articleService.add(articleEntity);

       String a= articleEntity.getArticleTypeEntity().getArticletypedetail();
       System.out.println(a);
    }

    @ResponseBody
    @GetMapping("/ok")
    public ArticleEntity findReply(){

       ArticleEntity articleEntity=articleService.findById(2);

       return  articleEntity;

    }


}
