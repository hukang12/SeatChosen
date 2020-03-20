
Page({

  /**
   * 页面的初始数据
   */
  data: {
    selectArr:'',
    seatArr:'',
    seatLocation:'',
    row:'',
    col:'',
    src:'sit_admit.png',
    name:''
  },
 
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //console.log(options);
      wx.showLoading({
        title: '疯狂加载中……'
      })
      var name = options.name;
      var row = options.row;
      var col = options.col;
      var src = "sit_admit.png";
      var seat = {}
      var seatArr = new Array(row);
      for(var i=0;i<row;i++){
        seatArr[i] = new Array(col);
        for(var j=0;j<col;j++){ 
          //随机产生不可选座位
          var random_seat = Math.ceil(Math.random() * col);
          if(random_seat%3==0){
            seat.src = "sit_ban.png";
          }else{
            seat.src = src;
          }
          
          seatArr[i][j] = seat;
          seat = {}
        }
      }
      this.setData({
        name:name,
        seatArr:seatArr
      })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    wx.hideLoading();//加载完毕
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
  /*选择座位 显示座位号 */
  seat_click:function(e){
    var that = this;
    //console.log(e.currentTarget.dataset);
    //console.log(that.data.selectArr.length);
    var toastRow = e.currentTarget.dataset.x + 1;
    var toastCol = e.currentTarget.dataset.y + 1;
    var select_src = e.currentTarget.dataset.src;
    //seatArr[4][2].src
    //var src = 'seatArr[' + (toastRow-1) + '][' + (toastCol-1) +'].src';
    
    var src = 'seatArr[' + e.currentTarget.dataset.x + '][' + e.currentTarget.dataset.y +'].src';
    //console.log(src);
    var select_seat = {
      x:toastRow,
      y:toastCol
    }
    
    /*
    判断座位类型
    1.可选
    2.已选
    3.不可选
    */
    
    if (select_src == 'sit_admit.png'){
      if (that.data.selectArr.length == 0){
        var arr = new Array();
        arr.push(select_seat);
        that.setData({
          [src]:'sit_chosen.png',
          selectArr:arr,
          seatLocation: toastRow + '排' + toastCol + '座'          
        })
        //console.log(src);
      }else{
        wx.showToast({
          title: '最多预约一个座位',
          icon: 'none'
        })
      }
      
    } else if (select_src == 'sit_chosen.png'){
      //取消选定座位  console.log(that.data.selectArr[0]);
      
      let arr = that.data.selectArr;  //let：局部变量   var:函数体内的全局变量
      arr.splice(0,1);//从选定座位数组删去1个座位
      that.setData({
        [src]:'sit_admit.png',
        seatLocation:''
      })
    }else{
      wx.showToast({
        title: '该座位已被预约！',
        icon: 'none'
      })
    }
  },
  //提交预约座位
  submitSelect:function(e){
    var account = '20162550';
    var name = this.data.name;
    var time = new Date();
    var location = this.data.seatLocation;
    var body={
      userAccount:account,
      roomName:name,
      seatLocation:location,
      selectTime:time,
      signInTime:'',
      signOutTime:''

    }
    console.log(e);
    if (this.data.seatLocation!=""){
      wx.showToast({
        title: '预约成功！',
        icon: ''
      })
      //页面跳转到签到页面
      var name = e.currentTarget.dataset.name;
      var location = e.currentTarget.dataset.location;
      wx.redirectTo({
        url: '../sits/success/success?name=' + name + '&location=' + location,
      })
      //预约信息写入数据库
      wx.request({
        url: 'http://localhost:8083/sitchosen/order/addOrder',
        data: JSON.stringify(body),
        method:'POST',
        success: function (res) {
          if (res.data.success) {
            wx.showToast({
              title: '操作成功',
              icon: '',
              duration: 2000
            });

            
          } else {
            wx.showToast({
              title: '操作失败',
              icon: '',
              duration: 2000
            });
          }
          
        }
      })
    }else{
      wx.showToast({
        title: '请先选择座位！',
        icon: 'none'
      })
    }
    
    
  },
  //随机选择座位
  randomSelect:function(e){

    var that = this;
    var selectLocation = that.data.seatLocation;
    if(selectLocation != ''){
      wx.showToast({
        title: '您已经选择了座位',
        icon:'none'
      })
    }else{
      var randomRow = Math.ceil(Math.random() * (that.data.row-1));
      var randomCol = Math.ceil(Math.random() * (that.data.col-1));
      var arr = new Array();
      arr.push({
        x:randomRow,
        y:randomCol
      })
      var src = 'seatArr['+(randomRow - 1)+']['+(randomCol - 1)+'].src';
      
      console.log(src+randomRow+'排'+randomCol+'列');
      console.log(that);
      that.setData({
        [src]:'sit_chosen.png',
        seatArr:arr,
        seatLocation: randomRow + '排' + randomCol + '列'
      })
    }
  }
})