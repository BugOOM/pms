package pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pms.entity.HouseModel;
import pms.entity.Owner;
import pms.entity.SysUser;
import pms.mapper.OwnerMapper;
import pms.mapper.UserMapper;
import pms.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerMapper ownerMapper;

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<HouseModel> findAll() {
		// TODO Auto-generated method stub
		return ownerMapper.findAll();
	}

	@Override
	public Integer total() {
		// TODO Auto-generated method stub
		return ownerMapper.total();
	}

	@Override
	@Transactional
	public void insertOwner(Owner owner, SysUser user) {
		// TODO Auto-generated method stub
		ownerMapper.insertOwner(owner);

		userMapper.updateUser(owner.getOwnerId(), user.getId());
	}

	@Override
	public void updateOwner(Owner owner, SysUser user) {
		// TODO Auto-generated method stub
		ownerMapper.updateOwner(owner, user);
	}

}
