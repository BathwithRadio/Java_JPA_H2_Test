package model;

import model.entity.proxy.Member;
import model.entity.proxy.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    //
    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA_H2_Test");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
//            saveUserAndTeam(em);
//            printUserAndTeam(em);
//            proxyLoadCheck(em);
            findMember(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void saveUserAndTeam(EntityManager em) {
        //
        Team team1 = new Team("Team1","팀1");
        Member member1 = new Member("Member1", "유저1", team1);
        em.persist(team1);
        em.persist(member1);
    }

    public static void printUserAndTeam(EntityManager em) {
        //
        Member member = em.find(Member.class, "Member1");
        Team team = member.getTeam();
        System.out.println("회원 이름 :: " + member.getUsername());
        System.out.println("소속팀 :: " + team.getName());
    }

    public static void printUser(EntityManager em) {
        //
        Member member = em.find(Member.class, "Member1");
        System.out.println("회원 이름 :: " + member.getUsername());
    }

    public static void proxyReturn(EntityManager em) {
        //
        Team team = em.getReference(Team.class, "Team1");

        System.out.println(team.getName());
    }

    public static void proxyCompare(EntityManager em) {
        //
        Member member = em.find(Member.class, "Member1");
        Team team = em.find(Team.class, "Team1"); // SQL을 실행
        member.setTeam(team);
        System.out.println(team.getName());
    }

    public static void proxyLoadCheck(EntityManager em) {
        //
        Team team = em.getReference(Team.class, "Team1");
        boolean isLoad = em.getEntityManagerFactory()
                .getPersistenceUnitUtil().isLoaded(team);
        System.out.println("isLoad ::: " + isLoad);
        System.out.println("Proxy Check ::: " + team.getClass().getName());
    }

    public static void findMember(EntityManager em) {
        //
        Member member = em.find(Member.class, "Member1");
        Team team = member.getTeam(); // 객체 그래프 탐색
        System.out.println(team.getName()); // 팀 엔티티 사용
    }
}
