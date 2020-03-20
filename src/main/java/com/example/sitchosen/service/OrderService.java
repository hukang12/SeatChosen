package com.example.sitchosen.service;

import com.example.sitchosen.entity.OrderInfo;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/17 12:25
 */
public interface OrderService {
    List<OrderInfo> getAllOrder();
    List<OrderInfo> getByAccount(String userAccount);
    int addOrder(OrderInfo order);
    boolean modifyOrder(OrderInfo order);
    boolean modifySignIn(int id);
    boolean modifySignOut(int id);
    boolean cancelOrder(int id);
}
