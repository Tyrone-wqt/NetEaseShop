package com.wqt.service.serviceImpl;

import com.wqt.dao.CartDao;
import com.wqt.pojo.Cart;
import com.wqt.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/3/9.
 */
@Service("cartService")
public class CartServiceImpl implements CartService{
    @Resource
    private CartDao cartDao;
    @Override
    public void addContentById(int contentId, int userId, int num) {
        cartDao.addContentById(contentId,userId,num);
    }

    @Override
    public List<Cart> getCartListByUserId(int userId) {
        return cartDao.getCartListByUserId(userId);
    }

    @Override
    public int deleteCartByCartId(int cartId) {
        return cartDao.deleteCartByCartId(cartId);
    }

    @Override
    public int deleteCartByUserId(int userId) {
        return cartDao.deleteCartByUserId(userId);
    }
}
