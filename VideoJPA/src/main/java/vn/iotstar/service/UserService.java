package vn.iotstar.service;

import vn.iotstar.entity.User;

public interface UserService {

	void insert(User user);

	boolean register(String email, String password, String username, String fullname, int roleid, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	User login(String username, String password);

	User findByUserName(String username);
}
