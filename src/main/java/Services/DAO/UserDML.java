package Services.DAO;

import Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDML{

    public  void insert(EntityManager em, String firstName, String lastName, int age, String email, String phone) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setEmail(email);
        user.setPhone(phone);
        em.persist(user);
    }


    public  void delete(EntityManager entityManager, Long userId){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        User resultSet =  entityManager.find(User.class, userId);
        entityManager.remove(resultSet);
        tx.commit();

    }


    public void update(EntityManager em, Long userId, String password) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        User resultSet =  em.find(User.class, userId);
        resultSet.setPassword(password);
        em.merge(resultSet);
        tx.commit();

    }

}
