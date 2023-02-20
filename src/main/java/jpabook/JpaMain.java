package jpabook;

import hellojpa.Member;
import hellojpa.Team;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("TeamA");
            // team.getMembers().add(member); 역방향(주인이 아닌방향)만 연관관계 설정하면 null값 들어감!!!
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            // member.changeTeam(team);
            em.persist(member);

            team.addMember(member); // 연관관계 편의메소드는 1에 넣어도 되고 n에 넣어도 됨

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            for(Member m : members){
                System.out.println("m = " + m.getUsername());
            }

            tx.commit(); // 커밋을 해줘야 반영이 된다

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close(); // 닫아줘야 리소스가 릴리즈된다
    }

}
