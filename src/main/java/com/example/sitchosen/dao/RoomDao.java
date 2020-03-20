package com.example.sitchosen.dao;

import com.example.sitchosen.entity.RoomInfo;

import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/11 21:47
 */
public interface RoomDao {
    //展示自习室信息
    List<RoomInfo> showRoomInfo();

    //查找单条信息
    RoomInfo findByRoomId(int roomId);
    //增加自习室
    int insertRoom(RoomInfo roomInfo);

    //修改自习室
    int updateRoom(RoomInfo room);

}
