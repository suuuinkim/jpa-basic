package jpabook;

import hellojpa.Member;
import hellojpa.Team;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

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
//            Order order = new Order();
            // 방법 1
            // order.addOrderItem(new OrderItem());
            // 방법 2
//            em.persist(order);
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("kim");
            em.persist(book);

            tx.commit(); // 커밋을 해줘야 반영이 된다

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close(); // 닫아줘야 리소스가 릴리즈된다
    }

}
