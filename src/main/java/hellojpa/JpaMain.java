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
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

//            Member member = new Member();
//            // 비영속
//            member.setId(101L);
//            member.setName("HelloJPA");

//            em.persist(member); // db에 저장되는건 아님 -> 1차 캐시에 저장됨

            // 영속
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L); // 이미 findMember1(똑같은)이 1차 캐시 안에 있기 때문에 findMember2는 조회를 하지 않음!
//            System.out.println("result = " + (findMember1 == findMember2)); // true 반환


            // 영속
            // jpa는 다시 set을 해줄 필요가 없다! Collection과 같다고 생각하자 "변경감지기능"
            // jpa는 값을 바꾸면 트랙잭션 되는 커밋시점에 변경을 반영하는구나라고 생각하기!
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");
//
//            if(member.getName().equals("ZZZZZ")){
//                em.persist(member);
//            }

//            Member member = new Member(200L, "member200");
//            em.persist(member);

//             강제호출, 1차 캐시가 지워지는건 아님!
//             플러시는 변경내용을 데이터베이스에 동기화 하는 것임!
//
//             em.flush();


            tx.commit(); // 커밋을 해줘야 반영이 된다

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close(); // 닫아줘야 리소스가 릴리즈된다
    }
}
