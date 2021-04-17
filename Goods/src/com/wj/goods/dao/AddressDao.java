package com.wj.goods.dao;

import com.wj.goods.util.JdbcUtil;

import java.sql.SQLException;

public class AddressDao {

    /**
     *
     * @param id member id
     * @param pid province id
     * @param cid city id
     * @param extra
     * @return
     * @throws SQLException
     */
    public static int insert(int id, int pid, int cid, String extra) throws SQLException {
        Object[] params = new Object[]{id,pid,cid,extra};

        int update = JdbcUtil.getQueryRunner().update("insert into address(id,pid,cid,extra) values(?,?,?,?)", params);
        //返回受影响的行数
        return update;
    }
}
