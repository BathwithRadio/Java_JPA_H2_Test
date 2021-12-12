package start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MemberDataInsert {
    //
    public static EntityManagerFactory memberInsert(){
        //
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA_H2_Test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        //----------데이터 등록----------
        transaction.begin(); // transaction start
        Member memberA = new Member();
        memberA.setId("memberA");
        memberA.setUsername("회원A");

        Member memberB = new Member();
        memberB.setId("memberB");
        memberB.setUsername("회원B");

        em.persist(memberA);
        em.persist(memberB);
        //----------데이터 등록----------

        transaction.commit();

        return emf;
    }
}
