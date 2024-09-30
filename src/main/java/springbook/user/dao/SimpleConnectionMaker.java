package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB 커넥션 담당
 */
public class SimpleConnectionMaker {

    /**
     * DB 커넥션 생성
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/springbook", "spring", "1948");

        return c;
    }
}
