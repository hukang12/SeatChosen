// pages/setting/order/order.js
const utils = require('../../../utils/util.js')
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
      url: 'http://localhost:8083/sitchosen/order/getAll',
      method: "GET",
      success: function (res) {
        var list = res.data.orders;
        for(var i=0;i<list.length;i++){
          list[i].selectTime = utils.formatTime(new Date(list[i].selectTime));
          //console.log(list[i]);
        }
        //var d = list[0].selectTime;
        //var date = utils.formatTime(new Date(d));
        // console.log(date);
        if (list == null) {
          wx.showToast({
            title: '获取数据失败',
            icon: "none",
            duration: 2000
          })
        } else {
          that.setData({ 
            orderList: list,

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

  renderTime:function(date){
    var dateee = new Date(date).toJSON();
    return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
  }
})