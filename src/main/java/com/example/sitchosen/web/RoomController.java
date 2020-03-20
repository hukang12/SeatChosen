package com.example.sitchosen.web;

import com.example.sitchosen.entity.RoomInfo;
import com.example.sitchosen.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/13 11:15
 */
@RestController
@RequestMapping("/roomAdmin")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @RequestMapping(value = "/getAllRoom",method = RequestMethod.GET)
    private Map<String,Object> getAllRoom(){
        Map<String,Object> map = new HashMap<>();
        List<RoomInfo> list = roomService.getRoomInfo();
        map.put("RoomList",list);
        return map;
    }
    @RequestMapping(value = "/getRoomById",method = RequestMethod.GET)
    private Map<String,Object> getRoomById(int roomId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("room",roomService.getRoomById(roomId));
        return modelMap;
    }
    @RequestMapping(value = "/addRoom",method = RequestMethod.POST)
    private Map<String,Object> addRoom(@RequestBody RoomInfo room){
        //System.out.println(room.toString());
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",roomService.addRoom(room));
        return modelMap;
    }
    @RequestMapping(value = "/modifyRoom",method = RequestMethod.POST)
    private Map<String,Object> modifyRoom(@RequestBody RoomInfo room){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",roomService.modifyRoom(room));
        return modelMap;
    }
}
