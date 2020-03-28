package pms.service;

import pms.entity.Owner;
import pms.entity.SysUser;

public interface UserService {
	void insertUser(SysUser user);

	SysUser findUserByUsername(String username);

	Owner selectOwnerById(Integer id);

	void updatePassword(String username, String password);

	void updateEmail(SysUser user);

	SysUser findUserByEmail(String email);

	SysUser findUserByOwnerId(Integer ownerId);
}
