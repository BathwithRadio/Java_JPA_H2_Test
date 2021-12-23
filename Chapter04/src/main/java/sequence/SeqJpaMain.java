package sequence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Time;
import java.util.Date;

public class SeqJpaMain {
    //
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA_H2_Seq_Test");
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

    private static void logic(EntityManager em) {
        Board board = new Board();
        board.setName("zzzz");
        board.setDate(new Date());
        board.setTime(new Time(121212));
        board.setTransientVal("Set Transient Value");
        Board board2 = new Board();
        board2.setName("yyyy");
        board2.setDate(new Date());
        board2.setTime(new Time(121212));
        board2.setTransientVal("Set Transient Value");
//        Board board3 = new Board();
//        board.setName("aaaa");
//        Board board4 = new Board();
//        board.setName("yydddyy");
//        Board board5 = new Board();
//        board.setName("vcvc");
        em.persist(board);
        em.persist(board2);
//        em.persist(board3);
//        em.persist(board4);
//        em.persist(board5);
        System.out.println("board.id => " + board.getId());
        System.out.println("board.date => " + board.getDate());
        System.out.println("board.time => " + board.getTime());
        System.out.println("board.transientVal => " + board.getTransientVal());
        System.out.println("board2.id => " + board2.getId());
        System.out.println("board2.date => " + board2.getDate());
        System.out.println("board2.transientVal => " + board2.getTransientVal());
//        System.out.println("board3.id => " + board3.getId());
//        System.out.println("board4.id => " + board4.getId());
//        System.out.println("board5.id => " + board5.getId());
    }
}
