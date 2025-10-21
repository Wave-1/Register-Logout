package vn.iotstar.service.impl;

import vn.iotstar.Dao.UserDao;
import vn.iotstar.Dao.impl.UserDaoImpl;
import vn.iotstar.entity.User;
import vn.iotstar.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = userDao.findByUserName(username);
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }
        return null;
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean register(String email, String password, String username, String fullname, int roleid, String phone) {
        // Kiểm tra trùng username, email, phone
        if (userDao.checkExistUsername(username) || userDao.checkExistEmail(email) || userDao.checkExistPhone(phone)) {
            return false;
        }

        // Tạo user mới
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setUserName(username);
        newUser.setFullName(fullname);
        newUser.setPassWord(password);
        newUser.setRoleid(roleid);
        newUser.setPhone(phone);
        newUser.setCreatedDate(date);

        userDao.insert(newUser);
        return true;
    }
}
