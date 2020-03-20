package com.example.sitchosen.dao;

import com.example.sitchosen.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/2/25 19:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void showUserInfo() {
        List<UserInfo> userInfoList = userDao.showUserInfo();
        System.out.println(userInfoList.get(0).toString());
    }
    @Test
    public void queryUserByAccount(){
        try{
            UserInfo userInfo = userDao.queryUserByAccount("201625");
            System.out.println(userInfo.getUserPassword());
        }catch (Exception e){
            System.out.println("用户名不存在！");
        }

    }
    @Test
    public void addUser() {
        UserInfo userInfo = new UserInfo("20162549","胡文超",1,"13678789966","45678@qq.com","666");
        boolean b = userDao.addUser(userInfo);
        System.out.println(b);
    }

    @Test
    public void updatePsd() {
        boolean res = userDao.updatePsd("15970613328", "263318");
        System.out.println(res);
    }
}