package com.example.sitchosen.dao;

import com.example.sitchosen.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/2/25 19:39
 */
public interface UserDao {
    //显示用户信息
    List<UserInfo> showUserInfo();
    //根据账号获取密码-->用于验证
    UserInfo queryUserByAccount(String userAccount);


    //注册
    boolean addUser(UserInfo userInfo);
    //重置（修改）密码
    boolean updatePsd(@Param("userTel")String userTel, @Param("userPassword")String userPassword);
}
