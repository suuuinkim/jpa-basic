package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// @Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    private int age;

    //@ManyToOne(fetch = FetchType.LAZY) // 프록시객체로 만든다
    @ManyToOne(fetch = FetchType.EAGER) // 즉시 로딩 (실무에서는 지양해야됨)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne // 일대일 관계
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> product = new ArrayList<>();

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

/*    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this); // 연관관계 편의 메소드
    }*/


}
