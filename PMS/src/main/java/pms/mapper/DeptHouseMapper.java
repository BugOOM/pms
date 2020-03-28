package pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pms.entity.DeptHouse;

public interface DeptHouseMapper {
	List<DeptHouse> findDeptHouse(@Param("deptId") Integer deptId, @Param("houseNum") String houseNum,
			@Param("ownerName") String ownerName, @Param("ownerPhone") String ownerPhone);

	Integer countDeptHouse(@Param("deptId") Integer deptId, @Param("houseNum") String houseNum,
			@Param("ownerName") String ownerName, @Param("ownerPhone") String ownerPhone);

	List<DeptHouse> findUserDeptHouse(@Param("deptId") Integer deptId, @Param("houseNum") String houseNum);

	Integer countUserDeptHouse(@Param("deptId") Integer deptId, @Param("houseNum") String houseNum);
}
