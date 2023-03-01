package jpql;


import javax.persistence.*;
import java.util.List;

import static jpql.MemberType.ADMIN;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("관리자");
            member.setAge(10);
            member.setType(ADMIN);
            em.persist(member);

            member.setTeam(team);

//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
//            타입정보가 명확하지 않을 때 사용
//            Query query3 = em.createQuery("select m.username, m.age from Member m");

//            singleResult는 명확하게 결과가 1개만 나와야됨
//            Member singleResult = query1.getSingleResult();

//            결과가 없으면 빈 리스트가 반환되기 때문에 NULLPOINTEREXCEPTION은 걱정하지 않아도 된다
//            List<Member> resultList = query1.getResultList();

//            Member singleResult = em.createQuery("select m from Member m where m.username = :username", Member.class)
//                    .setParameter("username", "memberA").getSingleResult();
//
//            System.out.println("singleResult = " + singleResult.getUsername());

            // Member는 영속성 컨테이너에서 관리가 될까?

            em.flush();
            em.clear();

//            String query = "select m.username, 'HELLO', true from Member m " +
//                    "where m.type= :userType";
//            List<Object[]> resultList = em.createQuery(query)
//                    .setParameter("userType", MemberType.ADMIN).getResultList();
//
//            for (Object[] objects : resultList) {
//                System.out.println("objects = " + objects[0]);
//                System.out.println("objects = " + objects[1]);
//                System.out.println("objects = " + objects[2]);
//            }

//            case 조건
//            String query =
//                            "select " +
//                                "case when m.age <= 10 then '학생요금'" +
//                                "     when m.age >=60 then '경로요금'" +
//                                "     else '일반요금' " +
//                                "     end " +
//                            "from Member m";

//            String query = "select coalesce(m.username, '관리자') from Member m ";
//            List<String> resultList = em.createQuery(query, String.class).getResultList();


//            for (String s : resultList) {
//                System.out.println("s = " + s);
//            }
            
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
