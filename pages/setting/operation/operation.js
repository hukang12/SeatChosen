// pages/setting/operation/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    roomId: undefined,
    addUrl: 'http://localhost:8083/sitchosen/roomAdmin/addRoom',
    editUrl: 'http://localhost:8083/sitchosen/roomAdmin/modifyRoom'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    console.log(options.roomId)
    this.setData({
      roomId:options.roomId
    })
    if (options.roomId == undefined){
      return;//表示点击的是添加按钮
    }
    wx.request({
      url: 'http://localhost:8083/sitchosen/roomAdmin/getRoomById',
      data:{"roomId":options.roomId},
      method: 'GET',
      success:function(res){
        console.log(res);
        var room = res.data.room;
        if(room == undefined){
          wx.showToast({
            title: '获取数据失败' + res.data.errMsg,
            icon: '',
            duration: 2000
          });
        }else{
          that.setData({
            roomName:room.roomName,
            roomFloor:room.roomFloor,
            seatRow:room.seatRow,
            seatCol:room.seatCol,
            seatAvailable:room.seatAvailable
          });
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  formSubmit:function(e){
    var that = this;
    var formData = e.detail.value;
    console.log(formData);
    var url = that.data.addUrl;//默认为添加按钮
    //console.log(that.data);
    if (that.data.roomId != undefined) {//若非undefined 则是编辑
      formData.roomId = that.data.roomId;
      url = that.data.editUrl;
    }
  
    wx.request({
      url: url,
      data: JSON.stringify(formData),
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res){
        if (res.data.success){
          wx.showToast({
            title: '操作成功',
            icon:'',
            duration:2000
          });
          wx.navigateBack({
            
          })
        }else{
          wx.showToast({
            title: '操作失败',
            icon: '',
            duration: 2000
          });
        }
        //console.log(res.data);
      }
    })
  }
})