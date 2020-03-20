package com.example.sitchosen.dao;

import com.example.sitchosen.entity.OrderInfo;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/17 10:36
 */
public interface OrderDao {
    //获取所有预约信息
    List<OrderInfo> findAll();
    //根据用户账号查询预约信息
    List<OrderInfo> findByAccount(String userAccount);
    //根据Id找预约记录
    OrderInfo findById(int orderId);
    //插入预约信息(签到前)
    int insertOrder(OrderInfo order);
    //修改预约信息(签到后)修改签到时间、释放座位时间
    int updateOrder(OrderInfo order);
    //签到
    int updateSignIn(OrderInfo order);
    //释放
    int updateSignOut(int orderId,Date signOutTime);
    //取消预约
    int cancelOrder(int orderId);

}
