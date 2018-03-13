package com.wqt.service;

import com.wqt.pojo.Cart;

import java.util.List;

/**
 * Created by lenovo on 2018/3/9.
 */
public interface CartService {
    public void addContentById(int contentId,int userId,int num);

    public List<Cart> getCartListByUserId(int userId);

    public int deleteCartByCartId(int cartId);

    public int deleteCartByUserId(int userId);
}
