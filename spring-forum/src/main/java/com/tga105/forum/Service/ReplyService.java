package com.tga105.forum.Service;

import com.tga105.forum.Enity.ReplyEnity;
import com.tga105.forum.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {

    @Autowired
    ReplyRepository replyRepository;





    public  void add(ReplyEnity replyEnity){
        replyRepository.save(replyEnity);

    }
    public List<ReplyEnity> findAll(){

        return  replyRepository.findAll();
    }

    public ReplyEnity findOne(Integer id){

        return  replyRepository.findById(id).get();
    }
}
