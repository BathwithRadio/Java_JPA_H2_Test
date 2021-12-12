package start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPA_update_logic {
    //
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 호출
        EntityManagerFactory emf = MemberDataInsert.memberInsert();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //영속 엔티티 데이터 조회
        Member foundMemberA = em.find(Member.class, "memberA");
        //조회 확인
        System.out.println("호출된 MemberA 이름 ::: " + foundMemberA.getUsername());

        //영속 엔티티 데이터 수정
        foundMemberA.setUsername("modified nameA");

        //em.update(); - 없는 메소드

        transaction.commit();
    }
}
