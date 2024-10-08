package hello.HelloSpring.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
//    strategy는 기본 키 생성 전략을 지정하는 속성입니다. G
//    enerationType.IDENTITY는 데이터베이스의 "auto-increment" 기능을 활용하여
//    기본 키를 자동으로 생성합니다.
//    주요 생성 전략:
//    AUTO: JPA가 전략을 자동으로 선택합니다. (기본값)
//    IDENTITY: 데이터베이스에 의존하여 자동 증가 필드(auto increment)를 사용합니다.
//    SEQUENCE: 데이터베이스 시퀀스를 사용하여 기본 키를 생성합니다. (Oracle, PostgreSQL에서 주로 사용)
//    TABLE: 키 생성 전용 테이블을 사용하여 기본 키를 관리합니다.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}