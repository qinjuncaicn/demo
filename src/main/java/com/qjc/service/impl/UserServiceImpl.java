package com.qjc.service.impl;

import com.qjc.mapper.UserMapper;
import com.qjc.model.User;
import com.qjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper mapper;



    @Override
    public User querUser() {

        return  mapper.selectByPrimaryKey();
    }

    @Override
    public int addUser(User user) {
        return mapper.insertSelective(user);
    }
}
