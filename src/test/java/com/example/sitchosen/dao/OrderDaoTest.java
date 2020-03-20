package com.example.sitchosen.dao;

import com.example.sitchosen.entity.OrderInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/17 15:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {
    @Autowired
    OrderDao orderDao;
    @Test
    public void findAll() {
        List<OrderInfo> list = orderDao.findAll();


            System.out.println(list.get(2).toString());


    }
}