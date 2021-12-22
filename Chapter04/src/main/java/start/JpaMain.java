package start;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA_H2_Test");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {

        Member member = new Member();
//        member.setId("member1");
        member.setUsername("회원1");
        Member memberB = new Member();
//        memberB.setId("memberB");
        memberB.setUsername("회원B");
        //등록
        em.persist(member);
        em.persist(memberB);
        System.out.println("member id : " + member.getId());
        System.out.println("memberB id : " + memberB.getId());
//        //한 건 조회
//        Member findMember = em.find(Member.class, "member1");
//        System.out.println("findMember=" + findMember.getUsername());

        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size=" + members.size());
        for (Member mem : members) {
            System.out.println(mem.getId());
            System.out.println(mem.getUsername());
        }
//
//        Member a = em.find(Member.class, "member1");
//        Member b = em.find(Member.class, "member1");
//
//        System.out.print("a and b are same :: ");
//        System.out.println(a == b);

    }
}
