package com.wqt.service;

import com.wqt.pojo.User;

/**
 * Created by lenovo on 2018/3/4.
 */
public interface LoginService {
    public User findUserByUserName(String userName);
}
