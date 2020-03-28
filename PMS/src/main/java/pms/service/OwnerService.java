package pms.service;

import java.util.List;

import pms.entity.HouseModel;
import pms.entity.Owner;
import pms.entity.SysUser;

public interface OwnerService {
	List<HouseModel> findAll();

	Integer total();

	void insertOwner(Owner owner, SysUser user);

	void updateOwner(Owner owner, SysUser user);
}
