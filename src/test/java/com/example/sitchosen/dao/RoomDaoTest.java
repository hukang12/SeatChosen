package com.example.sitchosen.dao;

import com.example.sitchosen.entity.RoomInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/12 15:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomDaoTest {
    @Autowired
    RoomDao roomDao;
    @Test
    public void showRoomInfo() {
        List<RoomInfo> list= roomDao.showRoomInfo();
        int i=0;
        while (i<list.size()){
            System.out.println(list.get(i).toString());
            i++;
        }

    }
}