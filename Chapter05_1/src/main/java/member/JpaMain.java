package member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA_H2_Test");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            testSave(em);  //등록
//            deleteRelation(em);
//            findAllObject(em);
//            finaAllJPQL(em);
            biDirection(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void testSave(EntityManager em) {
        //
        //팀1 저장
        Team team1 = new Team("team1", "팀1");

        //회원1
        Member member1 = new Member("member1", "회원1", team1);
        em.persist(member1);
        //회원2
        Member member2 = new Member("member2", "회원2", team1);
        em.persist(member2);

        // 이걸 추가해야한다고??
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);
        em.persist(team1);

//        team1.setMembers(members);
//        member1.setTeam(null);
//        member2.setTeam(null);
//        em.remove(team1);
    }

    public static void findAllObject(EntityManager em) {
        //
        Member member1 = em.find(Member.class, "member1");
        System.out.println(member1.getId());
        System.out.println(member1.getUsername());
        System.out.println(member1.getTeam().getName());
        System.out.println("======================");

        Member member2 = em.find(Member.class, "member2");
        System.out.println(member2.getId());
        System.out.println(member2.getUsername());
        System.out.println(member2.getTeam().getName());
        System.out.println("======================");
    }

    public static void finaAllJPQL(EntityManager em) {
        //
        String jpql = "select m from Member m join m.team t where " +
                "t.name =:teamName";

        List<Member> members = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();
        for (Member mem : members) {
            System.out.println(mem.getId());
            System.out.println(mem.getUsername());
            System.out.println(mem.getTeam().getName());
            System.out.println("======================");
        }
    }

    public static void updateRelation(EntityManager em) {
        //
        //새로운 팀
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        //회원1에 새로운 팀2 설정
        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);
    }

    public static void deleteRelation(EntityManager em) {
        //

        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null);
    }

    public static void biDirection(EntityManager em) {
        //
        System.out.println("biDirection 호출");
        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();
        for (Member mem : members) {
            System.out.println(mem.getId());
            System.out.println(mem.getUsername());
            System.out.println(mem.getTeam().getName());
            System.out.println("======================");
        }
    }
}

