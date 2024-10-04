package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 빈 팩토리를 위한 오브젝트 설정 클래스
 * 현재 XML과 같은 스프링 전용 설정정보를 담고 있다.
 */
@Configuration
public class DaoFactory {

    /**
     * UserDao 객체 생성
     * @return
     */
    @Bean
    public UserDao userDao() {

        return new UserDao(connectionMaker());
    }

    /**
     * Connection을 결정하고 생성하는 메소드로,
     * 여러 DAO를 생성하는 메소드가 추가될 경우 Connection에 관한 중복 코드를 제거하기 위해 메소드로 분리.
     * @return
     */
    @Bean
    public ConnectionMaker connectionMaker() {

        return new DConnectionMaker();
    }
}
