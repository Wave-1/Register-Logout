package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface UserService {

	void insert(UserModel user);

	boolean register(String email, String password, String username, String fullname, int roleid, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	UserModel login(String username, String password);

	UserModel findByUserName(String username);
}
