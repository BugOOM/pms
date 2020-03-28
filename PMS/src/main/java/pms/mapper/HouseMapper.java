package pms.mapper;

import org.apache.ibatis.annotations.Param;

import pms.entity.House;

public interface HouseMapper {
	void insertHouse(@Param("houseNum") String houseNum, @Param("deptId") Integer deptId);

	void updateHouse(@Param("houseId") Integer houseId, @Param("ownerId") Integer ownerId);

	House findHouseByHouseId(Integer houseId);
}
