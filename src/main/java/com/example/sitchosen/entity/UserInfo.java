package com.example.sitchosen.entity;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/2/25 15:23
 */
public class UserInfo {
    private String userAccount;
    private String userName;
    private int userSex;
    private String userTel;
    private String userEmail;
    private String userPassword;

    public UserInfo() {
    }

    public UserInfo(String userAccount, String userName, int userSex, String userTel, String userEmail, String userPassword) {
        this.userAccount = userAccount;
        this.userName = userName;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userAccount='" + userAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userTel='" + userTel + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
