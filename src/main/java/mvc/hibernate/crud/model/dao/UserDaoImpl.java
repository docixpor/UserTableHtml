package mvc.hibernate.crud.model.dao;

import mvc.hibernate.crud.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManagerFactory entityManagerFactory;
    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional
    @Override
    public void add(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        User updatedUser = entityManager.merge(user);
        transaction.commit();
        return updatedUser;
    }

    @Transactional
    @Override
    public void deleteUserFromTable(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        transaction.commit();
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
        return users;
    }

    @Transactional
    @Override
    public User findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        User user = entityManager.find(User.class, id);
        transaction.commit();
        return user;
    }
}
