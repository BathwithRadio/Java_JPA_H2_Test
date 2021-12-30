package ManyToMany;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA_H2_Test_Ch6_2");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            testSave(em);
//            find(em);
            findInverse(em);
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
        Product productA = new Product();
        productA.setId("product1");
        productA.setName("상품A");

        Member member1 = new Member("회원1");
        member1.setId("member1");
        // 양방향 연관관계 설정
        productA.getMembers().add(member1);
        member1.getProducts().add(productA);

        em.persist(member1);
        em.persist(productA);
    }

    public static void find(EntityManager em) {
        //
        Member member = em.find(Member.class, "member1");
        List<Product> products = member.getProducts();
        for (Product product : products) {
            System.out.println("Product name ::: " + product.getName());
        }
    }

    public static void findInverse(EntityManager em){
        //
        Product product = em.find(Product.class, "product1");
        List<Member> members = product.getMembers();
        for (Member member : members) {
            System.out.println("member = " + member.getUsername());
        }
    }
}

