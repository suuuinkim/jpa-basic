package jpabook;


import jpabook.jpashop.domain.Member;
import org.hibernate.Hibernate;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Order order = new Order();
            // 방법 1
            // order.addOrderItem(new OrderItem());
            // 방법 2
//            em.persist(order);
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);

//            Book book = new Book();
//            book.setName("JPA");
//            book.setAuthor("kim");
//            em.persist(book);

            Member member1 = new Member();
            member1.setName("hello1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("hello2");
            em.persist(member2);


            em.flush();
            em.clear();

//            Member m1 = em.find(Member.class, member1.getId());
//            System.out.println("m1 === " + m1.getClass()); // jpabook.jpashop.domain.Member
//
//            Member reference = em.getReference(Member.class, member1.getId());
//            System.out.println("reference = " + reference.getClass()); // jpabook.jpashop.domain.Member
//            System.out.println("a == a : " + (m1 == reference)); // true JPA는 == 비교를 보장

            Member referenceMember = em.getReference(Member.class, member1.getId());
            System.out.println("referenceMember = " + referenceMember.getClass()); // Proxy
            // referenceMember.getName(); // 강제 초기화
            Hibernate.initialize(referenceMember); // 강제 초기화
            // 만약 영속성컨테이너에서 꺼낸다면??? detach, close, clear 동일
            // 더이상 관리 안함
            // no Session 오류가 남
            // em.detach(referenceMember);
            // em.close();
            //em.clear();
            // referenceMember.getName();

            // System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(referenceMember));
            tx.commit(); // 커밋을 해줘야 반영이 된다

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close(); // 닫아줘야 리소스가 릴리즈된다
    }


    // 프록시 객체는 타입체크시 주의하기
    private static void extracted(Member m1, Member m2) {
        System.out.println("m1 === m2 : " + (m1 instanceof Member));
        System.out.println("m1 === m2 : " + (m2 instanceof Member));
    }

//    private static void printMemberAndTeam(Member member){
//        String username = member.getUsername();
//        System.out.println("username = " + username);
//
//        Team team = member.getTeam();
//        System.out.println("team = " + team.getName());
//    }

}
