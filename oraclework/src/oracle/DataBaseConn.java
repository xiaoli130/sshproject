package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 基础连接类
 * 方法：
 *  静态方法 加载驱动程序
 *  公有方法 建立数据库连接
 *  公有方法 关闭数据库连接
 * @author Mr
 *
 */
public class DataBaseConn {
	
	//数据库连接地址
    private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
    //用户名
    private static String username= "xiaoli";
    //密码
    private static String password ="xiaoli";
    //静态方法执行之前就已经加载了驱动程序
  

    /**
     * 建立与数据库的连接
     * @param url a database url of the form jdbc:subprotocol:subname
     * @param user 用户名
     * @param pwd 密码
     * @return 数据库连接/null
     */
    /*获取数据库连接 */
    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭与数据库的连接
    public static void closeConnection(Connection connection){
        if(connection!=null){
            try {
                connection.close();//释放数据库连接和JDBC资源
          //      System.out.println("close jdbc`s resources Success!!!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
