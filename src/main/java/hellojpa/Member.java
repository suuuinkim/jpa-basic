package hellojpa;

import javax.persistence.*;

// @Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    private int age;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;


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
