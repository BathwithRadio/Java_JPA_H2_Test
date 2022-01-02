package ManyToMany;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA_H2_Test_Ch6_2");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            testSave(em);
            testFind(em);
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
        //회원 저장
        Member member1 = new Member();
        member1.setId("member1");
        member1.setUserName("회원1");
        em.persist(member1);

        //상품 저장
        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        //회원상품 저장
        Orders orders = new Orders();
        orders.setMember(member1);
        orders.setProduct(productA);
        orders.setOrderAmount(2);
        em.persist(orders);
    }

    public static void testFind(EntityManager em) {
        //
        Long ordersId = 1L;
        Orders orders = em.find(Orders.class, ordersId);

        Member member = orders.getMember();
        Product product = orders.getProduct();

        System.out.println("member :::: " + member.getUserName());
        System.out.println("product :::: " + product.getName());
        System.out.println("orderAmount :::: " + orders.getOrderAmount());
    }

}

