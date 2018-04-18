package com.qjc.service;

import com.qjc.model.User;

public interface UserService {

    public User querUser();

    public int addUser(User user);
}
