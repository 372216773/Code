package DBUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Handler;

public class Ops1 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(Ops1.class.getClassLoader().getResourceAsStream("db_druid.properties"));
        //properties.load(Ops1.class.getResourceAsStream("./db_druid.properties"));
        //创建Druid连接池,有很多连接对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接对象
        Connection connection = dataSource.getConnection();
        //创建DBUtils的核心操作类
        QueryRunner queryRunner = new QueryRunner(dataSource);

        //queryRunner.update("insert into user values(?,?,?)",new Object[]{4,"abc",14});
        //queryRunner.update("delete from user where id = 4");
        //queryRunner.update("update user set nickname = ? where id = ?",new Object[]{"Judy",3});

        Object[] params = new Object[]{};
        /*Object[] query = (Object[]) queryRunner.query("select * from user", params, new ArrayHandler());
        for (Object re : query) {
            System.out.print(re + " ");
        }*/

        // 实现ArrayListHandler,封装到数组中
        Object[] query = (Object[]) queryRunner.query("select * from user", params, new ResultSetHandler() {
            @Override
            public Object handle(ResultSet resultSet) throws SQLException {
                //获得的行数据的信息都在MetaData(元信息)中
                if (resultSet.next()) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    Object[] data = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        data[i] = resultSet.getObject(i + 1);
                    }
                    return data;
                }
                return null;
            }
        });
/*        for (Object o : query) {
            System.out.println(o);
        }*/

        //实现MapListHandler,封装到List<Map<String,Object>>中
        List<Map<String, Object>> query1 = (List<Map<String, Object>>) queryRunner.query("select * from user", params, new ResultSetHandler() {
            @Override
            public Object handle(ResultSet resultSet) throws SQLException {
                List<Map<String, Object>> list = new ArrayList<>();
                while (resultSet.next()) {
                    //获得元数据
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    Map<String, Object> map = new HashMap<>();
                    for (int i = 0; i < columnCount; i++) {
                        String name = metaData.getColumnName(i + 1);
                        Object object = resultSet.getObject(i + 1);
                        map.put(name, object);
                    }
                    list.add(map);
                }
                return list;
            }
        });
        System.out.println(query1);

        //List<Map<String, Object>> query2 = (List<Map<String, Object>>) queryRunner.query("select * from user", params, new MapListHandler());
        //System.out.println(query2);

    }
}
