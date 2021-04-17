package com.dadacar.entity;

public class Member {

    private Integer id;//会员ID
    private String nickname;//用户名
    private String password;//密码

    public Member(Integer id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }

    public Member() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
