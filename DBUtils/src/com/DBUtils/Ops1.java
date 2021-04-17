package com.DBUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class Ops1 {
    private Object String;

    public static void main(String[] args) throws Exception {
        //创建资源对象
        Properties dbProp = new Properties();

        //给资源对象(dbProp)加载配置的数据
        dbProp.load(Ops1.class.getClassLoader().getResourceAsStream("db.properties"));

        //创建连接池对象,配置数据传给dataSource对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(dbProp);

        //创建DBUtils的核心操作类(queryRunner),操作对象为dataSource
        //new的时候不传参数,就要再加一条语句,setDataSource()赋值
        QueryRunner queryRunner = new QueryRunner(dataSource);

        /*queryRunner.update("CREATE TABLE member(\n" +
                "  `id` int NOT NULL AUTO_INCREMENT ,\n" +
                "  `nickname` varchar(64) DEFAULT NULL ,\n" +
                "\t`password` VARCHAR(64) ,\n" +
                "  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ");*/
        //增删改查都使用update方法
        /*queryRunner.update("insert into member(nickname,password) value(?,?)",new String[]{"admin1","admin1"});
        queryRunner.update("insert into member(nickname,password) value(?,?)",new String[]{"admin2","admin2"});
        queryRunner.update("insert into member(nickname,password) value(?,?)",new String[]{"admin3","admin3"});
        queryRunner.update("insert into member(nickname,password) value(?,?)",new String[]{"admin4","admin4"});*/

        //事务的操作 DBUtils中带Connection参数的方法,都是进行事务操作的
        //Connection connection = dataSource.getConnection();

        //连接对象是否自动提交
        //connection.setAutoCommit(false);
        //queryRunner.update(connection,"update member set nickname=? where id=?",new Object[]{"root",1});
        //connection.commit();
        //回滚
        //connection.rollback();
        String sql = "select * from member where id > 0";
        Object[] query = (Object[]) queryRunner.query(sql, new ResultSetHandler() {
            @Override
            public Object handle(ResultSet resultSet) throws SQLException {
                /*int row = 0;
                String[] data = new String[resultSet.getRow()];
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    for (int i = 1; i < columnCount; i++) {
                        data[row]  += resultSet.getObject(i).toString();
                    }
                    row++;
                }*/
                ResultSetMetaData metaData = resultSet.getMetaData();
                Object[] data = {"","","",""};
                int count = 0;
                while(resultSet.next()){
                    for (int i = 0; i < metaData.getColumnCount(); i++) {
                        //行号不含零
                        data[count] += metaData.getColumnName(i+1) +":" + resultSet.getObject(i+1)+" ";
                    }
                    count++;
                }
                return data;
            }
        });
        for (Object o : query) {
            System.out.println(o);
        }
    }

}

