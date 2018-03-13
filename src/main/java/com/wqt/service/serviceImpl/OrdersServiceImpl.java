package com.wqt.service.serviceImpl;

import com.wqt.dao.CartDao;
import com.wqt.dao.OrdersDao;
import com.wqt.pojo.Order;
import com.wqt.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/3/10.
 */
@Service("orderService")
public class OrdersServiceImpl implements OrdersService{
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private CartDao cartDao;
    @Override
    public int insertOrdersFromCartByUserId(int userId) {
        int rows=ordersDao.insertOrdersFromCartByUserId(userId);
        cartDao.deleteCartByUserId(userId);
        return rows;
    }

    @Override
    public List<Order> getOrderListByUserId(int userId) {
        return ordersDao.getOrderListByUserId(userId);
    }
}
