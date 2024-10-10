package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 빈 팩토리를 위한 오브젝트 설정 클래스로 설정 정보를 담고 있다
 * 기존 DaoFactory와 다른 점은 Connection을 결정하고 바로 반환하는 DaoFactory와 달리
 * DConnection 오브젝트 대신 CountingConnectionMaker 오브젝트로 바꿔치기 하여 반환한다.
 */
@Configuration
public class CountingDaoFactory {

    /**
     * UserDao 객체 생성
     * 기존과 다른 점은 없다
     * @return
     */
    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker()); // 모든 DAO는 여전히 connectionMaker()에서 만들어지는 오브젝트를 DI 받음
    }

    /**
     * 외부적으로는 Connection을 결정하고 생성하는 메소드
     * 내부적으로는 realConnectionMaker에서 Connection을 결정하고 생성하며
     * 이 메소드에서는 새로 만든 CountingConnectionMaker와 DConnectionMaker의 관계를 설정한다.
     * @return
     */
    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realConnectionMaker());
    }

    /**
     * 진짜로 Connection을 결정하고 생성하는 메소드
     * @return
     */
    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new DConnectionMaker();
    }
}
