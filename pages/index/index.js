// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    user:'',
    password:'',
    open: false,
    // mark 是指原点x轴坐标
    mark: 0,
    // newmark 是指移动的最新点的x轴坐标 
    newmark: 0,
    istoright: true
  },
  // 点击左上角小图标事件
  tap_ch: function (e) {
    if (this.data.open) {
      this.setData({
        open: false
      });
    } else {
      this.setData({
        open: true
      });
    }
  },

  tap_start: function (e) {
    // touchstart事件
    // 把手指触摸屏幕的那一个点的 x 轴坐标赋值给 mark 和 newmark
    this.data.mark = this.data.newmark = e.touches[0].pageX;
  },

  tap_drag: function (e) {
    // touchmove事件
    this.data.newmark = e.touches[0].pageX;

    // 手指从左向右移动
    if (this.data.mark < this.data.newmark) {
      this.istoright = true;
    }

    // 手指从右向左移动
    if (this.data.mark > this.data.newmark) {
      this.istoright = false;
    }
    this.data.mark = this.data.newmark;
  },

  tap_end: function (e) {
    // touchend事件
    this.data.mark = 0;
    this.data.newmark = 0;
    // 通过改变 opne 的值，让主页加上滑动的样式
    if (this.istoright) {
      this.setData({
        open: true
      });
    } else {
      this.setData({
        open: false
      });
    }
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

  //提交表单验证登录
  formSubmit:function(e){
    if(e.detail.value.userAccount==""){
      wx.showToast({
        title: '用户名不能为空！',
        icon:'none',
        duration:1000
      })
    }else if(e.detail.value.userPassword==""){
      wx.showToast({
        title: '密码不能为空！',
        icon: 'none',
        duration: 1000
      })
    }else{
      console.log(e.detail.value);
      var formData = e.detail.value;
      wx.request({
        url: 'http://localhost:8083/sitchosen/superadmin/login',
        data: {
          user: formData.userAccount,
          password: formData.userPassword,
        },
        method: 'GET',
        header: {
          'Content-Type': 'application/json'
        },
        success: function (res) {
          var result = res.data;
          if (result) {
            wx.showToast({
              title: '登录成功！',
              icon: '',
              duration:1000
            }),
            wx.navigateTo({
              url: '../sits/sits',
            })
          } else {
            wx.showToast({
              title: '用户名或密码错误！',
              icon: 'none',
              duration:1000
            })
          }
          console.log(res.data);
        }
      })
    }
    
    
  },

  register:function(){
    wx.navigateTo({
      url: '/pages/register/register',
    })
  },
  forget_psd:function(){
    wx.navigateTo({
      url: '/pages/forget_psd/forget_psd',
    })
  },
  // 侧边栏JS
  toRoomSetting: function () {
    wx.navigateTo({  
      url: '../setting/roomSetting/roomSetting',
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  updatePassword: function () {
    wx.navigateTo({
      url: '../forget_psd/forget_psd',
    })
  },
  toAboutUs: function () {
    console.log("das");
    wx.navigateTo({
      url: '../setting/aboutUs/aboutUs',
    })
  },
  click: function () {
    console.log(this);
    wx.showToast({
      title: '点击了',
    })
  },
  //预约记录
  findOrder: function () {
    wx.navigateTo({
      url: '../setting/order/order',
    })
  }
})