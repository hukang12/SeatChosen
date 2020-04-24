// pages/sits/success/success.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    status:'待签到',
    orderId:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var name = options.name;
    var location = options.location;
    var orderId = options.orderId;
    console.log(options);
    this.setData({
      name: name,
      location: location,
      orderId:orderId
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
  handleClick:function(e){
    var that = this;
    var button_id = e.currentTarget.id;
    var status = this.data.status;
    var orderId = that.data.orderId;
    //console.log(e.currentTarget.id);
    console.log(this.data);
    var toastTxt = '';
    if(status == ""){
      wx.showToast({
        title: '您还没有预约座位哦！',
        icon:'none'
      });
      return;
    }
    if(button_id==1){
      if(status == '学习中'){
        toastTxt = '您已签到，好好学习吧！';
      }else{
        //签到功能实现
        //var sign_in_time = new Date();
        wx.request({
          url: 'http://localhost:8083/sitchosen/order/SignIn',
          data:{
            id: orderId
          },
          method:'GET',
          success:function(res){
            console.log(e);
          }
        })

        toastTxt = '签到成功';
        that.setData({
          status:'学习中'
        })
      }
      
    }else if(button_id==2){
      if (status != '学习中') {
        toastTxt = '请先签到哦！';
      } else {
        //暂离功能实现
        toastTxt = '暂离成功';
      }
    }else{
      if(status != '学习中'){
        toastTxt = '释放失败，请先签到哦！';
      }else{
        //释放功能实现
        wx.request({
          url: 'http://localhost:8083/sitchosen/order/SignOut',
          data:{
            id: orderId
          },
          method:'GET'
        })
        toastTxt = '释放成功';
        wx.showToast({
          title: toastTxt,
          icon: 'none',
          duration: 1000,

        })
        that.setData({
          status:'已完成'
        })
        wx.navigateBack({
          delta:3
        })
      }
      
    }
    wx.showToast({
      title: toastTxt,
      icon: 'none',
      duration: 1000,
    
    })
  }
})