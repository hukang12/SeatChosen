package com.example.sitchosen.web;

import com.example.sitchosen.entity.UserInfo;
import com.example.sitchosen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/3 15:47
 */
@RestController
@RequestMapping("/superadmin")
public class UserController {
    @Autowired
    UserService userService;

    //@PostMapping(value = "/register")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    private Map<String,Object> register(@RequestBody UserInfo userInfo){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",userService.register(userInfo));

        System.out.println(userInfo.toString());
        return modelMap;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    private boolean loginConfirm(String user,String password){
        return userService.loginConfirm(user, password);
    }



    @RequestMapping(value = "/updatePwd",method = RequestMethod.GET)
    private boolean updatePwd(String userTel,String newPwd){
        return userService.updatePsd(userTel,newPwd);
    }

}
