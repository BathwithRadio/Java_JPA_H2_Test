package model;

import model.entity.embeddedId.EmParent;
import model.entity.embeddedId.EmParentId;
import model.entity.idclass.Parent;
import model.entity.item.Album;

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
            //TODO 비즈니스 로직
//            saveAlbum(em);
            saveEmbedded(em);
            findemParent(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void saveAlbum(EntityManager em) {
        //
        Album album1 = new Album("Artist", "ETC");
        em.persist(album1);
    }

//    public static void saveParent(EntityManager em) {
//        //
//        Parent parent = new Parent();
//        parent.setId1("myId1");
//        parent.setId2("myId2");
//        parent.setName("parentName");
//        em.persist(parent);
//    }
//
//    public static void findParent(EntityManager em) {
//        //
//        ParentId parentId = new ParentId("myId1", "myId2");
//        Parent parent = em.find(Parent.class, parentId);
//    }

    public static void saveEmbedded(EntityManager em) {
        //
        EmParent parent = new EmParent();
        EmParentId parentId = new EmParentId("myId1", "myId2");
        parent.setId(parentId);
        parent.setName("parentName");
        em.persist(parent);
    }

    public static void findemParent(EntityManager em) {
        //
        EmParentId parentId = new EmParentId("myId1", "myId2");
        EmParent parent = em.find(EmParent.class, parentId);
        System.out.println(parent.getId().getId1());
        System.out.println(parent.getId().getId2());
        System.out.println(parent.getName());
        System.out.println(parentId.hashCode());
    }
}
