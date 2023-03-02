package mvc.hibernate.crud.model.dao;

import mvc.hibernate.crud.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    void add(User user);
    User updateUser(User user);
    void deleteUserFromTable(Long id);
    List<User> getAllUsers();

    User findById(Long id);
}
