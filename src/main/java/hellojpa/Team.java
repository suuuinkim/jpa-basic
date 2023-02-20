package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    // mappedBy의 정체 -> 읽기전용 가짜매핑이라고 생각하기
    // 객체의 양방향 관계는 사실 서로 다른 단방향 관계가 2개인 것!
    // 테이블로 봤을 때 외래키가 있는 곳을 주인으로 정할 것! - 디비입장에서 외래키가 있는 곳이 무조건 다(n)
    @OneToMany(mappedBy = "team") // 1:n 매핑에서 뭐라 연관되어있냐면 Member 클래스에 team 변수명과 매핑되어있다는걸 알려준다!
    private List<Member> members = new ArrayList<>(); // add 할 때 nullpoint 안뜸

    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }

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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
