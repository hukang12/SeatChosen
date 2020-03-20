// pages/forget_psd/forget_psd.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userTel:'',
    newPassword:''
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
    if (e.detail.value.userTel == "") {
      wx.showToast({
        title: '手机号不能为空！',
        icon: 'none',
        duration: 1000
      })
    } else if (e.detail.value.newPassword == "") {
      wx.showToast({
        title: '密码不能为空！',
        icon: 'none',
        duration: 1000
      })
    } else{
      wx.request({
        url: 'http://localhost:8083/sitchosen/superadmin/updatePwd',
        data:{
          userTel: e.detail.value.userTel,
          newPwd: e.detail.value.newPassword
        },
        success:function(res){
          //var toast ='重置密码失败！';
        
          if(res.data){ 
            wx.showToast({
              title: '重置密码成功，请重新登录！',
              icon: 'none',
              duration: 3000
            });
            wx.reLaunch({
              url: '../index/index',
            })
          }else{
            wx.showToast({
              title: '重置密码失败！',
              icon: 'none',
              duration: 1000
            })
          }
      
        },
        
      })
    }
  }
})