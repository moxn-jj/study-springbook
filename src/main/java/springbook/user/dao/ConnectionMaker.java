package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DB 연결 위한 인터페이스
 */
public interface ConnectionMaker {

    Connection makeConnection() throws ClassNotFoundException, SQLException;
}
