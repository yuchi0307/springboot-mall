package com.yuchi.springbootmall.dao;

import com.yuchi.springbootmall.dto.UserRegisterRequest;
import com.yuchi.springbootmall.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);
    User getDataById(Integer userId);

    User getUserByEmail(String email);
}
