package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Parent {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    // cascade는 언제쓸까?
    // 일대다에 써야될까? no
    // 소유자가 하나일때만 사용할 수 있다!!!
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,  orphanRemoval = true) // orphanRemoval = true : 컬렉션에서 빠진애는 삭제가 된다
    private List<Child> childList = new ArrayList<>();

    public void addChild(Child child){ // 양방향 연관관계를 넣기 위해서
        childList.add(child);
        child.setParent(this);
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

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }
}
