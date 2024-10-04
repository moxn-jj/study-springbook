
# 용어 정리
책에서 언급된 용어 정의에 대한 모음
1. DAO, Data Access Object: (1.1)
    - DB를 사용해 데이터 조회/조작하는 오브젝트
2. 자바빈, JavaBean: (1.1)
    - 디폴트 생성자와 프로퍼티(with setter/getter)를 가진 오브젝트
3. 리팩토링, Refactoring: (1.2)
    - 코드 품질 향상을 위해 외부의 동작방식에 변화 없이 내부 구조를 변경하는 것
4. 디자인 패턴, Design Pattern: (1.2)
    - 자주 만나는 문제를 해결하기 위한 재사용 가능한 솔루션
5. 템플릿 메소드 패턴, Template Method Pattern: (1.2)
    - 상속을 통해 슈퍼클래스의 기능을 확장할 때 사용하는 대표적인 방법
    - 변하지 않는 기능은 슈퍼클래스에, 자주 변경되는 기능은 서브클래스에 위치
6. 팩토리 메소드 패턴, Factory Method Pattern: (1.2)
   - 템플릿 몌소드 패턴과 마찬가지로 상속을 통해 기능 확장하는 패턴
   - 서브클래스에서 구체적인 오브젝트 생성 방법을 결정하게 하는 것
   ```
   템플릿 메소드 패턴과 팩토리 메소드 패턴의 차이점?
   
   템플릿 메소드 패턴은 슈퍼클래스의 메소드를 서브클래스에서 구현하다는 점이 특징이고,
   팩토리 메소드 패턴은 서브클래스에서 오브젝트 생성을 담당하고 리턴한다는 점이 특징이다.
   따라서 두 패턴은 동시에 발생하는 경우가 많다. 
   ```
7. 객체지향 설계 원칙, SOLID: (1.3)
   - 객체지향 설계를 할 때 지켜야할 원칙
   1. SRP, THE Single Responsibility Principle: 단일 책임 원칙
   2. OCP, The Open Closed Principle: 개방 폐쇄 원칙
   3. LSP, The Liskov Substitution Principle: 리스코프 치환 원칙
   4. ISP, The Interface Segregation Principle: 인터페이스 분리 원칙
   5. DIP, The Dependency Inversion Principle: 의존관계 역전 원칙
8. 빈, Bean: (1.5.3)
   - == 빈 오브젝트 (Bean Object), 관리되는 오브젝트 (Managed Object)
   - 스프링이 IoC 방식으로 관리하는 오브젝트
   - 스프링을 사용하는 애플리케이션에서 만들어지는 모든 오브젝트가 빈은 아니고, 그 중 스프링이 직접 생성과, 제어를 담당하는 오브젝트만을 말함
9. 빈 팩토리, Bean Factory: (1.5.3) 
   - 스프링의 IoC를 담당하는 핵심 컨테이너
   - 빈을 등록, 생성, 조회하며 빈을 관리하는 여러 기능을 담당
   - 보통 빈 팩토리를 바로 사용하기 보단 확장한 애플리케이션 컨텍스트를 이용
   - `BeanFactory`라고 붙여쓰면 빈 택토리가 구현하고 있는 가장 기본적인 인터페이스의 이름이 됨
10. 애플리케이션 컨텍스트, Application Context: (1.5.3)
    - 빈 팩토리를 확장한 IoC 컨테이너
    - 빈 팩토리가 하는 기능 + 스프링이 제공하는 각종 부가 서비스
    - `ApplicationConext`라고 붙여쓰면 애플리케이션 컨텍스트가 구현해야 하는 기본 인터페이스를 말함
    - `ApplicationConext`는 `BeanFactory`를 상속
11. 설정정보/설정 메타정보, Configuration metadata: (1.5.3)
    - == 애플리케이션의 형상 정보, 청사진 (blueprints) 
    - 애플리케이션 컨텍스트 또는 빈 팩토리가 IoC를 적용하기 위해 사용하는 메타정보
12. 컨테이너 또는 IoC 컨테이너, Container or IoC Container (1.5.3)
    - 애플리케이션 컨텍스트나 빈 팩토리의 동의어로, IoC 방식으로 빈을 관리한다는 의미에서 사용
    - 컨테이너라는 말 자체가 IoC의 개념을 담고 있으나, 애플리케이션 컨텍스트보다는 추상적인 표현
13. 스프링 프레임워크, Spring Framework (1.5.3)
    - IoC 컨테이너 ,애플리케이션 컨텍스트를 포함해서 스프링이 제공하는 모든 기능을 통틀어 말함