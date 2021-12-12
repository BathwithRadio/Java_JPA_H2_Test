package start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Entity_Transaction {
    //
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA_H2_Test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        //엔티티 매니저는 데이터 변경시 트랜잭션을 시작해야 한다.
        transaction.begin(); // transaction start

        Member memberA = new Member();
        memberA.setId("memberA");
        memberA.setUsername("회원A");

        Member memberB = new Member();
        memberB.setId("memberB");
        memberB.setUsername("회원B");

        em.persist(memberA);
        em.persist(memberB);
        //여기까지 Insert SQL을 데이터에 보내지 않는다.

        transaction.commit();
    }
}
