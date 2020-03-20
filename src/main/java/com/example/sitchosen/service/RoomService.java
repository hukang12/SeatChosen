package com.example.sitchosen.service;

import com.example.sitchosen.entity.RoomInfo;

import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/13 11:10
 */
public interface RoomService {
    List<RoomInfo> getRoomInfo();

    RoomInfo getRoomById(int roomId);

    boolean addRoom(RoomInfo room);

    boolean modifyRoom(RoomInfo room);
}
