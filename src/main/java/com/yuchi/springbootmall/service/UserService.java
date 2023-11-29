package com.yuchi.springbootmall.service;

import com.yuchi.springbootmall.dto.UserLoginRequest;
import com.yuchi.springbootmall.dto.UserRegisterRequest;
import com.yuchi.springbootmall.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
      Integer createUser(UserRegisterRequest userRegisterRequest);

      User getUserById(Integer userId);

      User login(UserLoginRequest userLoginRequest);

}
