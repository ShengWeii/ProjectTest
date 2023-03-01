package com.tga105.forum.Service;

import com.tga105.forum.Enity.ArticleTypeEntity;
import com.tga105.forum.Repository.ArticleRepository;
import com.tga105.forum.Repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleTypeService {

    @Autowired
    ArticleTypeRepository articleTypeRepository;
    public ArticleTypeEntity find(Integer articletypeid){
        return articleTypeRepository.findById(articletypeid).get();
    }

    public List<ArticleTypeEntity> findAll(){
        return  articleTypeRepository.findAll();
    }
}
