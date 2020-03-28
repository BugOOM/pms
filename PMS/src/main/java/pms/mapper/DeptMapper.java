package pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pms.entity.Dept;

public interface DeptMapper {
	void insertDept(Dept dept);

	List<Dept> findDept(@Param("deptId") Integer deptId);

	Integer countDept(@Param("deptId") Integer deptId);

	Integer findFloor(Integer deptId);
}
