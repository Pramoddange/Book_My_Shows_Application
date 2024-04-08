package com.acciojob.Book.My.Show.Application.repository;

import com.acciojob.Book.My.Show.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
   // public User findUserByMobNo(String mobNo);
    public User findUserByMobNo(String mobNo);
}
