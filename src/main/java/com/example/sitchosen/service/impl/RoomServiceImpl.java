package com.example.sitchosen.service.impl;

import com.example.sitchosen.dao.RoomDao;
import com.example.sitchosen.entity.RoomInfo;
import com.example.sitchosen.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/13 11:12
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    @Override
    public List<RoomInfo> getRoomInfo() {
        return roomDao.showRoomInfo();
    }

    @Override
    public RoomInfo getRoomById(int roomId) {
        return roomDao.findByRoomId(roomId);
    }

    @Override
    public boolean addRoom(RoomInfo room) {
        try {
            int res = roomDao.insertRoom(room);
            if(res>0){
                return true;
            }else {
                throw new Exception("插入信息失败！");
            }
        }catch (Exception e){
            throw new RuntimeException("插入信息失败！"+e.getMessage());
        }
    }

    @Override
    public boolean modifyRoom(RoomInfo room) {
        try {
            int res = roomDao.updateRoom(room);
            if(res>0){
                return true;
            }else {
                throw new Exception("插入信息失败！");
            }
        }catch (Exception e){
            throw new RuntimeException("插入信息失败！"+e.getMessage());
        }
    }
}
