package hellojpa;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
// @Entity
public class User {
    @Id
    private Long id;

    // nullable = false : notnull 제약조건이 걸림
    // unique = true : 잘 사용하지 않음
    // length = 길이 : 길이
    @Column(name = "name", nullable = false)
    private String username;


    private Integer age;

    // enum 주의 사항 : ORDINAL 사용을 지양해야됨!!!
    // 예를 들어, 요구사항이 늘어 GUEST 가 추가되었을때 순서의 문제가 생김!!!
    @Enumerated(EnumType.STRING)
    private RoleType roleType;


    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // 자바 8부터는 @Temporal을 사용하지 않아도 됨
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // 큰 콘텐츠
    private String description;

    @Transient // 매핑하고 싶지 않을때
    private int temp;
    // 기본 생성자 필요
    public User(){
        
    }

}