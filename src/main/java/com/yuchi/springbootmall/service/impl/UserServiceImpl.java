package com.yuchi.springbootmall.service.impl;

import com.yuchi.springbootmall.dao.UserDao;
import com.yuchi.springbootmall.dto.UserLoginRequest;
import com.yuchi.springbootmall.dto.UserRegisterRequest;
import com.yuchi.springbootmall.model.User;
import com.yuchi.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer createUser(UserRegisterRequest userRegisterRequest) {
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        //檢查Email帳號
        if(user != null){
            log.warn("該 email {} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // 使用 MD5 生成密碼雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassword);
        //創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getDataById(userId);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {

        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        //檢查 EMAIL 是否註冊
        if (user == null){
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //使用 MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());
        //資料庫創建的加密密碼 比對 前端傳過來的加密密碼是否一致
        if(user.getPassword().equals(hashedPassword)){
            return user;

        }else{
            log.warn("該email {} 密碼不正確", userLoginRequest.getEmail());
            log.warn("輸入的密碼 {} ",userLoginRequest.getPassword());
            log.warn("資料庫的密碼 {}", hashedPassword);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
