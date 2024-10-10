package springbook.user.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoConnectionCountingTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 기존과 동일하게 UserDao를 가져온다.
        // 하지만 다른 점이 있다. Dao 관계를 설정하는 Factory가 다르다.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        createAndSelectUser(dao); // dao 사용 코드

        // 빈에서 다루고 있던 CountingConnectionMaker를 가져와서 저장된 카운팅 수를 뽑아낸다.
        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : " + ccm.getCounter());
    }
    
    private static void createAndSelectUser(UserDao dao) throws ClassNotFoundException, SQLException {

        User user = new User();
        user.setId("moxn");
        user.setName("문");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
