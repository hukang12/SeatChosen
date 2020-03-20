package com.example.sitchosen.service.impl;

import com.example.sitchosen.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/2/28 11:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    public void loginConfirm() {
        userService.loginConfirm("20162550","12456");
    }
}