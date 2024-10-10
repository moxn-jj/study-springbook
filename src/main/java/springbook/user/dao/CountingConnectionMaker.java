package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 연결횟수 카운팅 기능을 추가한 DB 커넥션 관리 클래스
 */
public class CountingConnectionMaker implements ConnectionMaker {
    
    int counter = 0; // 연결 횟수를 저장
    private ConnectionMaker realConnectionMaker;

    /**
     * 생성자를 통해 실제 커넥션 타입을 주입 받는다.
     * 이로서 해당 클래스는 주입받는 realConnectionMaker에 런타임 시 의존관계가 형성된다.
     * @param realConnectionMaker
     */
    public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
        this.realConnectionMaker = realConnectionMaker;
    }

    /**
     * 외부적으로는 커넥션을 만들어서 반환한다.
     * 내부적으로는 커넥션을 만들라고 호출될 때마다 counting을 올리고
     * 실제로 커넥션 하는 객체는 생성자를 통해 주입받은 것을 리턴한다.
     * (여전히 커넥션 객체의 타입에 따라 커넥션을 생성 하는 것은 DConnectionMaker에게 책임이 있다)
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++; // 커넥션이 생성될 때 카운팅을 올림
        return realConnectionMaker.makeConnection();
    }

    public int getCounter() {
        return this.counter;
    }
}
