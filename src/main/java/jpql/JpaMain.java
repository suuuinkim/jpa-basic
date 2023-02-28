package jpql;


import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("memberA");
            em.persist(member);

//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
            //TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
            // 타입정보가 명확하지 않을 때 사용
            //Query query3 = em.createQuery("select m.username, m.age from Member m");

            // singleResult는 명확하게 결과가 1개만 나와야됨
//            Member singleResult = query1.getSingleResult();

            // 결과가 없으면 빈 리스트가 반환되기 때문에 NULLPOINTEREXCEPTION은 걱정하지 않아도 된다
//            List<Member> resultList = query1.getResultList();

            Member singleResult = em.createQuery("select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "memberA").getSingleResult();

            System.out.println("singleResult = " + singleResult.getUsername());

            tx.commit(); // 커밋을 해줘야 반영이 된다

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close(); // 닫아줘야 리소스가 릴리즈된다
    }




}
