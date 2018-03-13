package com.wqt.controller;

import com.wqt.pojo.User;
import com.wqt.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by lenovo on 2018/3/4.
 */
@Controller
public class LoginController {
    @Resource
    private LoginService loginService;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/onLogin")
    @ResponseBody
    public Map<String,Object> onLogin(String userName,String password,HttpSession session){
        //HttpSession session=request.getSession(true);
        Map<String,Object> map=new HashMap<String, Object>();
        User user=loginService.findUserByUserName(userName);
        if(user==null||!password.equals(user.getPassword())){
            map.put("code",201);
            map.put("message", "");
            map.put("result",false);
        }else{
            session.setAttribute("user",user);
            map.put("code",200);
            map.put("message", "success");
            map.put("result",true);
        }
        return map;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "forward:/login";
    }
}
