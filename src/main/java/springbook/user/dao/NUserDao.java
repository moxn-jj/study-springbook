package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * N사 전용 UserDao
 */
public class NUserDao extends UserDao {

    /**
     * N사 만을 위한 DB 커넥션
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/springbook", "spring", "1948");

        return c;
    }
}
