package start;

import javax.persistence.*;
import java.util.List;

/**
 * @author holyeye
 */
public class JpaMain {
    //
    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA_H2_Test");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            memberInsert(em); //데이터 입력
            logic(em);  //비즈니스 로직
            memberDelete(em); //데이터 1건 삭제 후 조회
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
        //한 건 조회
        Member findMember = em.find(Member.class, "memberA");
        System.out.println("findMember=" + findMember.getUsername());

        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        for (Member member : members){
            System.out.println("member name ::: " + member.getUsername());
        }
        System.out.println("members.size=" + members.size());

        //비교
//        Member a = em.find(Member.class, "member1");
//        Member b = em.find(Member.class, "member1");
//
//        System.out.print("a and b are same :: ");
//        System.out.println(a == b);

    }

    public static void memberInsert(EntityManager em ){
        //
        Member memberA = new Member();
        memberA.setId("memberA");
        memberA.setUsername("회원A");
        memberA.setAge(21);

        Member memberB = new Member();
        memberB.setId("memberB");
        memberB.setUsername("회원B");
        memberB.setAge(322);

        em.persist(memberA);
        em.persist(memberB);
    }

    public static void memberDelete(EntityManager em){
        //
        //삭제
        Member memberA = em.find(Member.class, "memberA");
        em.remove(memberA);
        //삭제 후 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        for (Member member : members){
            System.out.println("member name after deleted::: " + member.getUsername());
        }
    }
}
