package com.example.sitchosen.service;

import com.example.sitchosen.entity.OrderInfo;

import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/17 12:25
 */
public interface OrderService {
    List<OrderInfo> getAllOrder();
    List<OrderInfo> getByAccount(String userAccount);
    boolean addOrder(OrderInfo order);
    boolean modifyOrder(OrderInfo order);
}
