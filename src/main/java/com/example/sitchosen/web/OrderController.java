package com.example.sitchosen.web;

import com.example.sitchosen.entity.OrderInfo;
import com.example.sitchosen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/17 14:32
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    private Map<String,Object> getAllOrder(){
        Map<String,Object> map = new HashMap<>();
        List<OrderInfo> list = orderService.getAllOrder();
        map.put("orders",list);
        System.out.println(list.get(3).toString());
        return map;
    }
    @RequestMapping(value = "/getOwn",method = RequestMethod.GET)
    private Map<String,Object> getOrderByAccount(String userAccount){
        Map<String,Object> map = new HashMap<>();
        List<OrderInfo> list = orderService.getByAccount(userAccount);
        map.put("orders",list);
        return map;
    }
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    private Map<String,Object> addOrder(@RequestBody OrderInfo order){
        Map<String,Object> map = new HashMap<>();
        map.put("success",orderService.addOrder(order));
        return map;
    }
    @RequestMapping(value = "/modifyOrder",method = RequestMethod.POST)
    private Map<String,Object> modifyOrder(@RequestBody OrderInfo order){
        Map<String,Object> map = new HashMap<>();
        map.put("success",orderService.modifyOrder(order));
        return map;
    }
}
