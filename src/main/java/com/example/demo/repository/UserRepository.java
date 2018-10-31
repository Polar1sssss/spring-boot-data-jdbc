package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hujtb
 * @create on 2018-10-30-12:11
 */

//继承JpaRepository完成对数据库的操作
public interface UserRepository extends JpaRepository<User, Integer>{

}
