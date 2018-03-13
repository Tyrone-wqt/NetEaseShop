package com.wqt.service.serviceImpl;

import com.wqt.dao.LoginDao;
import com.wqt.pojo.User;
import com.wqt.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2018/3/4.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{
    @Resource
    LoginDao loginDao;
    @Override
    public User findUserByUserName(String userName) {
        return loginDao.findUserByUserName(userName);
    }
}
