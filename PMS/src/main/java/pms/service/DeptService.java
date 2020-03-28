package pms.service;

import pms.entity.Dept;
import pms.entity.Model;

public interface DeptService {
	void insertDept(Dept dept);

	Model findDept(Integer deptId, Integer page, Integer limit);

	Integer findFloor(Integer deptId);
}
