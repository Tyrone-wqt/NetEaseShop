package com.wqt.dao;

import com.wqt.pojo.Order;

import java.util.List;

/**
 * Created by lenovo on 2018/3/10.
 */
public interface OrdersDao {
    public int insertOrdersFromCartByUserId(int userId);

    public List<Order> getOrderListByUserId(int userId);
}
