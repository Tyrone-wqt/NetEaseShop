package com.wqt.controller;

import com.wqt.pojo.Order;
import com.wqt.pojo.User;
import com.wqt.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lenovo on 2018/3/10.
 */
@Controller
public class OrdersController {
    @Resource
    private OrdersService ordersService;
    @RequestMapping("/account")
    public String showAccount(HttpSession session,Model model){
        User user= (User) session.getAttribute("user");
        if(user==null) return "login";
        model.addAttribute("user",user);
        List<Order> orderList=ordersService.getOrderListByUserId(user.getId());
        model.addAttribute("orderList",orderList);
        return "account";
    }
}
