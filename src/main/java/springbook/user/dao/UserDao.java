package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

/**
 * 사용자 정보 관리 DAO
 *
 */
public abstract class UserDao {

    /**
     * 단일 사용자 추가
     *
     * @param user
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void add(User user) throws ClassNotFoundException, SQLException {

        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    /**
     * 단일 사용자 정보 조회
     * @param id 사용자 key
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));;
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    /**
     * DB 커넥션
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}
