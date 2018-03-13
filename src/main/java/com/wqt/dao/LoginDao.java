package com.wqt.dao;

import com.wqt.pojo.User;

/**
 * Created by lenovo on 2018/3/4.
 */
public interface LoginDao {
    public User findUserByUserName(String userName);
}
