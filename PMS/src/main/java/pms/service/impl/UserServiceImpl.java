package pms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pms.entity.Owner;
import pms.entity.SysUser;
import pms.mapper.OwnerMapper;
import pms.mapper.UserMapper;
import pms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OwnerMapper ownerMapper;

	@Override
	@Transactional
	public void insertUser(SysUser user) {
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
		userMapper.insertRole(user);
	}

	@Override
	public SysUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findUserByUsername(username);
	}

	@Override
	public Owner selectOwnerById(Integer id) {
		// TODO Auto-generated method stub
		return ownerMapper.selectOwnerById(id);
	}

	@Override
	public void updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		userMapper.updatePassword(username, password);
	}

	@Override
	public void updateEmail(SysUser user) {
		// TODO Auto-generated method stub
		userMapper.updateEmail(user);
	}

	@Override
	public SysUser findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userMapper.findUserByEmail(email);
	}

	@Override
	public SysUser findUserByOwnerId(Integer ownerId) {
		// TODO Auto-generated method stub
		return userMapper.findUserByOwnerId(ownerId);
	}

}
