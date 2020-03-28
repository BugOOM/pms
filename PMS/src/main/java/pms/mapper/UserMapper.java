package pms.mapper;

import org.apache.ibatis.annotations.Param;

import pms.entity.SysUser;

public interface UserMapper {
	void insertUser(SysUser user);

	void updateUser(@Param("ownerId") Integer ownerId, @Param("userId") Integer userId);

	void insertRole(SysUser user);

	SysUser findUserByUsername(String username);

	void updatePassword(@Param("username") String username, @Param("password") String password);

	void updateEmail(SysUser user);

	SysUser findUserByEmail(String email);

	SysUser findUserByOwnerId(Integer ownerId);
}
