package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 꼭 넣어야됨! jpa로 사용한다고 인식
// @Table(name="User")
public class Member {
    @Id
    private Long id;
    private String name;

    // jpa는 기본생성자가 있어야됨
    public Member(){
    }
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
