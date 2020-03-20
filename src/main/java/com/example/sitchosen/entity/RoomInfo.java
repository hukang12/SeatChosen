package com.example.sitchosen.entity;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/3/11 21:18
 */
public class RoomInfo {
    private int roomId;
    private String roomName;
    private int roomFloor;
    private int seatRow;
    private int seatCol;
    private int seatAvailable;

    @Override
    public String toString() {
        return "RoomInfo{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomFloor=" + roomFloor +
                ", seatRow=" + seatRow +
                ", seatCol=" + seatCol +
                ", seatAvailable=" + seatAvailable +
                '}';
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(int seatCol) {
        this.seatCol = seatCol;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(int seatAvailable) {
        this.seatAvailable = seatAvailable;
    }
}
