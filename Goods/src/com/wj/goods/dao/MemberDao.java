package com.wj.goods.dao;

import com.wj.goods.service.RegisterService;
import com.wj.goods.util.JdbcUtil;
import com.wj.goods.util.Md5Util;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class MemberDao {

    /**
     * 添加用户
     * @param nickname
     * @param password
     * @return
     * @throws SQLException
     */
    public int insert(String nickname,String password) throws SQLException {

        Object[] params = new Object[]{nickname,password};
        //添加数据,返回更新的行数
        int update = JdbcUtil.getQueryRunner().update("insert into member(nickname,password) values(?,?)", params);

        //返回0,即没有添加成功
        return update;
    }

    /**
     * 返回最后一个添加的id
     * @return
     * @throws SQLException
     */
    public int selectLastInsertId() throws SQLException {

        BigInteger query = (BigInteger) JdbcUtil.getQueryRunner().query("select last_insert_id()", new ScalarHandler());

        return query.intValue();

    }

    /**
     * 登录时校验账号和密码是否存在
     * @param nickname
     * @param password
     * @return
     * @throws SQLException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public int checkMember(String nickname, String password) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {

        String md5String = Md5Util.getMd5String(password);
        Object[] params = {nickname, md5String};
        long query = (long) JdbcUtil.getQueryRunner().query("select count(*) from member where nickname = ? and password = ?", params,new ScalarHandler());
        return (int) query;
    }

    /**
     * 注册时校验
     * @param nickname
     * @return
     * @throws SQLException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public int checkNickname(String nickname) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {

        Object[] params = {nickname};
        long query = (long) JdbcUtil.getQueryRunner().query("select count(*) from member where nickname = ?", params,new ScalarHandler());
        //返回受影响的行数,即找到返回值大于0
        return (int) query;
    }
}
