package utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Jason
 * @version 1.0
 * @date 6/2/2020 11:10 AM
 */
public class JDBCUtils {
    //*****************No JDBC Pool***********************
    /*
    private static String driver;
    private static String url;
    private static String userName;
    private static String password;
    */
    //****************************************************
    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
    private static Properties properties=new Properties();
    static {
        //*****************No JDBC Pool***********************
        /*
        try {


            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("mysql_config.properties"));
            driver=properties.getProperty(R.MYSQL_CONFIG.JDBC_DRIVER,"");
            url=properties.getProperty(R.MYSQL_CONFIG.JDBC_URL,"");
            userName=properties.getProperty(R.MYSQL_CONFIG.JDBC_USER,"");
            password=properties.getProperty(R.MYSQL_CONFIG.JDBC_PASSWORD,"");
            //Test
            //System.out.println(properties);
            //加载JDBC驱动
            Class.forName(driver);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         */
        //****************************************************
        try {
            InitialContext initialContext = new InitialContext();
            Context envContext = (Context)initialContext.lookup("java:comp/env");
            dataSource=(DataSource) envContext.lookup("vote_system_jdbc_pool");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        Connection connection=null;
        connection=threadLocal.get();
        if(connection==null){
            //*****************No JDBC Pool***********************
            //connection= DriverManager.getConnection(url,userName,password);
            //****************************************************
            connection=dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        Connection connection=threadLocal.get();

        if(connection!=null){
            connection.close();
        }
        threadLocal.set(null);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection=JDBCUtils.getConnection();
        System.out.println(connection);

    }

}
