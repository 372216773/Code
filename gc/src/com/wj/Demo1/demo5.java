package com.wj.Demo1;

import java.util.Objects;

public class demo5 {

    private int userId;
    private String userName;
    private String userPwd;

    public int getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserPwd() {
        return userPwd;
    }
    //获取私有属性
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "demo5{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
    //变为字符串

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        demo5 demo5 = (demo5) o;
        return userId == demo5.userId;
        //是否相等,比较的是userId的值
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
        //hashCode保持一致
    }
}
