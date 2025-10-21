package vn.iotstar.Dao;

import vn.iotstar.entity.*;

public interface UserDao {
	
	User findByUserName(String userName);

	void insert(User user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
}
