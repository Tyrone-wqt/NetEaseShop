package com.wqt.dao;

import com.wqt.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/3/9.
 */
public interface CartDao {
    public void addContentById(@Param("contentId") int contentId,@Param("userId")int userId,@Param("num") int num);

    public List<Cart> getCartListByUserId(int userId);

    public int deleteCartByCartId(int cartId);

    public int deleteCartByUserId(int userId);
}
