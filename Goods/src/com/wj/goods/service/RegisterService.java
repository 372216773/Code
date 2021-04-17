package com.wj.goods.service;

import com.wj.goods.dao.MemberDao;
import com.wj.goods.dao.AddressDao;
import com.wj.goods.util.Md5Util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class RegisterService {

    /**
     * 注册用户
     * @param nickname
     * @param password
     * @param pid
     * @param cid
     * @param extra
     * @throws SQLException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public void register(String nickname, String password, int pid, int cid, String extra) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {

        MemberDao memberDao = new MemberDao();
        //1.为member表添加数据
        memberDao.insert(nickname, Md5Util.getMd5String(password));

        //2.获得member的id作为address表的id插入
        int lastInsertId = memberDao.selectLastInsertId();

        //为address表添加数据
        AddressDao.insert(lastInsertId,pid,cid,extra);

    }

    /**
     * 检查是否存在此用户
     * @param nickname
     * @return
     * @throws UnsupportedEncodingException
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     */
    public boolean checkNickname(String nickname) throws UnsupportedEncodingException, SQLException, NoSuchAlgorithmException {
        MemberDao memberDao = new MemberDao();
        int i = memberDao.checkNickname(nickname);
        //存在账号
        if (i > 0) {
            return true;
        }else {//不存在用户
            return false;
        }

    }
}
