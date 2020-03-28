package pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pms.entity.HouseModel;
import pms.entity.Owner;
import pms.entity.SysUser;

public interface OwnerMapper {
	List<HouseModel> findAll();

	void insertOwner(Owner owner);

	Owner selectOwnerById(Integer id);

	Integer total();

	void updateOwner(@Param("owner") Owner owner, @Param("user") SysUser user);
}
