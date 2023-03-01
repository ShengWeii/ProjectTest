package com.tga105.forum.Service;

import com.tga105.forum.Enity.User;
import com.tga105.forum.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User find(Integer id){
        return  userRepository.findById(id).get();

    }
}
