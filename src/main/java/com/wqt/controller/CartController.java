package com.wqt.controller;

import com.wqt.dao.OrdersDao;
import com.wqt.pojo.Cart;
import com.wqt.pojo.User;
import com.wqt.service.CartService;
import com.wqt.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2018/3/9.
 */
@Controller
public class CartController {
    @Resource
    private CartService cartService;
    @Resource
    private OrdersService ordersService;
    @RequestMapping("/buy")
    @ResponseBody
    public Map<String,Object> addToCart(int buyId,int buyNum,HttpSession session){
        Map<String,Object> map=new HashMap<String, Object>();
        User user=(User)session.getAttribute("user");
        if(user==null){
            map.put("code",201);
            map.put("message", "please login");
            map.put("result",false);
        }
        cartService.addContentById(buyId,user.getId(),buyNum);
        map.put("code",200);
        map.put("message", "");
        map.put("result",true);
        return map;
    }

    @RequestMapping("/cart")
    public String showCart(HttpSession session,Model model){
        User user=(User)session.getAttribute("user");
        if(user==null)
            return "login";
        List<Cart> cartItemList=cartService.getCartListByUserId(user.getId());
        model.addAttribute("user",user);
        model.addAttribute("cartItemList",cartItemList);
        return "cart";
    }

    @RequestMapping("/deleteCart")
    @ResponseBody
    public Map<String,Object> deleteCart(int cartId,HttpSession session){
        User user=(User)session.getAttribute("user");
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("user",user);
        if (user != null && user.getUserType() == 0) {
            int rows = cartService.deleteCartByCartId(cartId);
            if (rows == 1){
                map.put("code", 200);
                map.put("result",true);
            }
            else{
                map.put("code", 201);
                map.put("result",false);
            }
        } else {
            map.put("code", 201);
            map.put("result",false);
        }
        return map;
    }

    @RequestMapping("/settle")
    @ResponseBody
    public Map<String,Object> clearAllContentInCart(HttpSession session){
        User user= (User) session.getAttribute("user");
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("user",user);
        if (user != null && user.getUserType() == 0) {
            int rows= ordersService.insertOrdersFromCartByUserId(user.getId());
            if (rows > 0){
                map.put("code", 200);
                map.put("result",true);
            }
            else{
                map.put("code", 201);
                map.put("result",false);
            }
        } else {
            map.put("code", 201);
            map.put("result",false);
            map.put("message","invalid user");
        }
        return map;
    }
}
