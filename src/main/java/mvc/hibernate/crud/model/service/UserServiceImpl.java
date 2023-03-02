package mvc.hibernate.crud.model.service;

import mvc.hibernate.crud.model.dao.UserDao;
import mvc.hibernate.crud.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//        users.add(new User("Ivan", "Ivanov", (byte) 12));
//        users.add(new User("Anton", "Antonov", (byte) 23));
//        users.add(new User("Maxim", "Maximov", (byte) 42));
//        users.add(new User("Egor", "Egorov", (byte) 18));
//        users.add(new User("Karim", "Karimov", (byte) 32));

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

//    @Override
//    public void saveUsers() {
//        userDao.saveUsers();
//    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUserFromTable(Long id) {
        userDao.deleteUserFromTable(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }
}
