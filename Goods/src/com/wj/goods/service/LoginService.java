package com.wj.goods.service;

import com.wj.goods.dao.MemberDao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class LoginService {

    //登录校验
    public String login(String nickname, String password) throws UnsupportedEncodingException, SQLException, NoSuchAlgorithmException {

        MemberDao memberDao = new MemberDao();
        int checkMember = memberDao.checkMember(nickname, password);

        //查到有这条记录的行数大于0
        if (checkMember > 0) {
            return "true";
        }else {
            return "false";
        }

    }

}
