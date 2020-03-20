// pages/chosen/chosen.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      
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
    var that = this;
    wx.request({
      url: 'http://localhost:8083/sitchosen/roomAdmin/getAllRoom',
      method:"GET",
      //data:{},
      success:function(res){
        var list = res.data.RoomList;
        if(list == null){
          wx.showToast({
            title: '获取数据失败',
            icon:"none",
            duration:2000
          })
        }else{
          that.setData({
            roomList:list
          })
        }
      }
    })
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
  tapTo_sit:function(e){
    var row = e.target.dataset.row;
    var col = e.target.dataset.col;
    var name = e.target.dataset.name;
    console.log("进入" + name + "自习室：" + row + "排" + col + "列");
    
    wx.navigateTo({
      url: '/pages/sits/sits?row='+row+'&col='+col+'&name='+name,
    })
  }
})