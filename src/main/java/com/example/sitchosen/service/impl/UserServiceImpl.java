package com.example.sitchosen.service.impl;

import com.example.sitchosen.dao.UserDao;
import com.example.sitchosen.entity.UserInfo;
import com.example.sitchosen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/2/28 11:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean loginConfirm(String userAccout,String userPassword){
        try{
            UserInfo userInfo = userDao.queryUserByAccount(userAccout);
            if(userPassword.equals(userInfo.getUserPassword())){
                System.out.println("登录成功！");
                return true;
            }else {
                System.out.println("密码错误！");
                return false;
            }
        }catch (Exception e){
            System.out.println("用户名不存在！");
            return false;
        }
    }

    @Override
    public boolean register(UserInfo userInfo) {

        if(userInfo.getUserAccount()!=null&&!"".equals(userInfo.getUserAccount())) {
            try {
                return userDao.addUser(userInfo);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean updatePsd(String userTel, String newPsd) {
        return userDao.updatePsd(userTel,newPsd);
    }
}
