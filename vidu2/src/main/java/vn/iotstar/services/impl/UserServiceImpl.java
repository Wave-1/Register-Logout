package vn.iotstar.services.impl;

import vn.iotstar.daos.UserDao;
import vn.iotstar.daos.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}

		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);

	}

	@Override
	public boolean register(String email, String password, String username, String fullname, int roleid, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(0, email, username, fullname, password, null, roleid, phone, date));
		return true;
	}
}
