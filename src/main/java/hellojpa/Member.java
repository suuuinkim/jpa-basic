package hellojpa;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class Member {
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
    public Member(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}