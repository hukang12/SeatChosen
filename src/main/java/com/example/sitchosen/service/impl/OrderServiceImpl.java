package com.example.sitchosen.service.impl;

import com.example.sitchosen.dao.OrderDao;
import com.example.sitchosen.entity.OrderInfo;
import com.example.sitchosen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/17 14:18
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    public List<OrderInfo> getAllOrder() {
        return orderDao.findAll();
    }

    @Override
    public List<OrderInfo> getByAccount(String userAccount) {
        return orderDao.findByAccount(userAccount);
    }

    @Override
    public int addOrder(OrderInfo order) {
        if(order.getUserAccount() != null && !"".equals(order.getUserAccount())){
            try {
                int res = orderDao.insertOrder(order);
                if(res > 0){
                    return order.getOrderId();
                }else {
                    throw new Exception("插入信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }

    }

    @Override
    public boolean modifyOrder(OrderInfo order) {
        if(order.getOrderId()>0){
            try{
                int res = orderDao.updateOrder(order);
                if (res > 0) {
                    return true;
                }else {
                    throw new RuntimeException("插入信息失败！");                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }

    }

    @Override
    public boolean modifySignIn(int id) {
        OrderInfo order = orderDao.findById(id);
        if(order!=null && order.getSignInTime()==null){

            try {
                Date signInTime = new Date();
                order.setSignInTime(signInTime);
                int res = orderDao.updateOrder(order);
                if(res>0){
                    return true;
                }else {
                    throw new Exception("插入签到信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("签到信息已存在！");
        }

    }

    @Override
    public boolean modifySignOut(int id) {
        OrderInfo order = orderDao.findById(id);
        if(order!=null && order.getSignOutTime()==null && order.getSignInTime() !=null){

            try {
                Date sign_out_time = new Date();
                order.setSignOutTime(sign_out_time);
                int res = orderDao.updateOrder(order);

                if(res>0){
                    return true;
                }else {
                    throw new Exception("插入释放信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("释放座位失败！"+e.getMessage());
            }
        }else {
            throw new RuntimeException("释放座位失败！");
        }
    }

    @Override
    public boolean cancelOrder(int id) {
        try {
            int res =  orderDao.cancelOrder(id);
            if(res>0){
                return true;
            }else {
                throw new Exception("取消预约失败！");
            }
        }catch (Exception e){
            throw new RuntimeException("取消预约失败！"+e.getMessage());
        }

    }
}
