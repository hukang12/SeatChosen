package com.example.sitchosen.service;

import com.example.sitchosen.entity.UserInfo;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/2/28 11:21
 */
public interface UserService {
    boolean loginConfirm(String userAccout,String userPassword);

    boolean register(UserInfo userInfo);

    boolean updatePsd(String userTel,String newPsd);
}
