package springbook.user.dao;

/**
 * 객체 생성을 담당하는 팩토리 클래스
 */
public class DaoFactory {

    /**
     * UserDao 객체 생성
     * @return
     */
    public UserDao userDao() {

        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    /**
     * Connection을 결정하고 생성하는 메소드로,
     * 여러 DAO를 생성하는 메소드가 추가될 경우 Connection에 관한 중복 코드를 제거하기 위해 메소드로 분리.
     * @return
     */
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
