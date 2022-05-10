package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {

    static {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        String password = "123456";
        String username = "root";
        String url = "jdbc:mysql://localhost:3366/stu_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
        return DriverManager.getConnection(url, username, password);
    }
}
