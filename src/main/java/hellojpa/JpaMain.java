package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

//            조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

//            수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            조건이 까다로워 진다면?
//            JPQL을 사용해야한다!
//            객체를 대상으로 검색하는 객체 지향 쿼리
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
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
