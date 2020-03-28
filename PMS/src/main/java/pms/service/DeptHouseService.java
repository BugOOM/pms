package pms.service;

import pms.entity.Model;

public interface DeptHouseService {

	Model findDeptHouse(Integer deptId, String houseNum, String ownerName, String ownerPhone, Integer page,
			Integer limit);

	Model findUserDeptHouse(Integer deptId, String houseNum, Integer page, Integer limit);

}
