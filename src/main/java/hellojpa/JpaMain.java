package hellojpa;

import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

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

//            Member2 member1 = new Member2();
//            member1.setUsername("A");
//
//            Member2 member2 = new Member2();
//            member2.setUsername("B");
//
//            Member2 member3 = new Member2();
//            member3.setUsername("C");
//
//            System.out.println("=======================");
//
//            em.persist(member1); // 1, 51
//            em.persist(member2); // MEM
//            em.persist(member3); // MEM
//
//            System.out.println("member1 = " + member1.getId());
//            System.out.println("member2 = " + member2.getId());
//            System.out.println("member3 = " + member3.getId());
//
//            System.out.println("=======================");


//            Team team = new Team();
//            team.setName("TeamA");
//            // team.getMembers().add(member); 역방향(주인이 아닌방향)만 연관관계 설정하면 null값 들어감!!!
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            // member.changeTeam(team);
//            em.persist(member);
//
//            team.addMember(member); // 연관관계 편의메소드는 1에 넣어도 되고 n에 넣어도 됨
//
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//
//            for(Member m : members){
//                System.out.println("m = " + m.getUsername());
//            }


//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);
//
//            em.flush();
//            em.close();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);


//            Member3 member = new Member3();
//            member.setUsrename("hello1");
//            member.setHomeAddress(new Address("city", "Street", "zipCode"));
//
//            // 값타입 컬렉션들은 라이프사이클이 같이 돌아감 왜냐하면 갑타입이기 때문에!!!
//            member.getFavoriteFood().add("치킨");
//            member.getFavoriteFood().add("피자");
//            member.getFavoriteFood().add("초밥");
//
//            member.getAddressHistory().add(new AddressEntity("seoul", "apple-street", "zipcode"));
//
//            em.persist(member);
//
//            // 디비에 값은 잇지만 깔끔한 상태로 조회!
//            em.flush();
//            em.clear();
//
//            System.out.println("================= START ==============");
//            Member3 findMember = em.find(Member3.class, member.getId());
//
//            // homeCity -> newCity
//            // 옳지 않은 예
////            findMember.getHomeAddress().setCity("newCity");
//
//            // 옳은 예
//            // 완전히 교체해야됨!
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
//
//            // 치킨 -> 한식
//            findMember.getFavoriteFood().remove("치킨");
//            findMember.getFavoriteFood().add("김치");
//
//            // 주소바꾸기
//            // equals의 중요성!!!
//            System.out.println("=============== START ==============");
//            findMember.getAddressHistory().remove(new Address("seoul", "apple-street", "zipcode")); // 오브젝트를 먼저 찾기
//            findMember.getAddressHistory().add(new AddressEntity("busan", "banana-street", "zipzipcode"));

            // 값타임 컬력션은 언제쓰는가?
            // 체크버튼이 있어서 체크체크 하는 경우
            // 추적할 필요도 없고 값이 바껴도 업데이트 할 필요 없을 때

            // 엔티티 타입 vs 값 타입
            // ------------------------
            // 식별자 있음 | 식별자 없음
            // 생명 주기 관리 | 생명주기를 엔티티에 의존
            // 공유         | 공유하지 않는 것이 안전(복사해서 사용) -> 불변객체로 사용하는 것이 안전


            // JPQL
//            List<Member3> resultList = em.createQuery(
//                    "select m from Member3 m where m.username like '%kim%'", Member3.class
//            ).getResultList();
//
//            for (Member3 member : resultList) {
//                System.out.println("member = " + member);
//            }

            // CriteriaBuilder
            // 동적쿼리를 작성하기 좋다
            // 실무에서 거의 사용 안함! 유지보수가 어려움! 왜냐하면 복잡하고 실용성이 없다
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member3> query = cb.createQuery(Member3.class);
//            Root<Member3> m = query.from(Member3.class);
//            CriteriaQuery<Member3> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//            List<Member3> resultList = em.createQuery(cq).getResultList();

            // flush -> commit, query

            //List<Member3> resultList = em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from Member3 ", Member3.class).getResultList();

            tx.commit(); // 커밋을 해줘야 반영이 된다

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close(); // 닫아줘야 리소스가 릴리즈된다
    }
}
