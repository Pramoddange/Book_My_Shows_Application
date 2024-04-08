package com.acciojob.Book.My.Show.Application.service;

import com.acciojob.Book.My.Show.Application.entity.User;
import com.acciojob.Book.My.Show.Application.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public String addUser(User user){
         user=userRepo.save(user);
        return "User has been save in Database with userId"+user.getUserId();
    }
}
