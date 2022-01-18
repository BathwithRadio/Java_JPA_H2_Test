package model;

import model.entity.cascade.Child;
import model.entity.cascade.Parent;
import model.entity.proxy.Member;
import model.entity.proxy.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

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
//            findMember(em);
            saveWithCascade(em);
//            orphanRemoval(em);
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
//        Order order1 = new Order("Order1", "주문1");
//        List<Order> orders = new ArrayList<>();
//        orders.add(order1);
        Member member1 = new Member("Member1", "유저1", 11, team1);
//        em.persist(order1);
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
//        Team team = member.getTeam(); // 객체 그래프 탐색
//        System.out.println(team.getName()); // 팀 엔티티 사용
//        team.getName();
    }

    //===============================
    public static void saveNoCascade(EntityManager em) {
        //
        //부모 저장
        Parent parent = new Parent();
        em.persist(parent);

        //1번 자식
        Child child1 = new Child();
        child1.setParent(parent);
        parent.getChildren().add(child1);
        em.persist(child1);

        //2번 자식
        Child child2 = new Child();
        child1.setParent(parent);
        parent.getChildren().add(child2);
        em.persist(child2);
    }

    public static void saveWithCascade(EntityManager em) {
        //
        Child child2 = new Child();
        Child child1 = new Child();

        Parent parent = new Parent("Parent1");
        //연관관계 추가
        child1.setParent(parent);
        child1.setParent(parent);

        parent.getChildren().add(child1);
        parent.getChildren().add(child2);

        em.persist(parent);

        Parent parent1 = em.find(Parent.class, "Parent1");
        parent1.getChildren().remove(0);
    }

    public static void orphanRemoval(EntityManager em) {
        //
        Parent parent = em.find(Parent.class, "Parent1");
        parent.getChildren().remove(0);
    }
}
