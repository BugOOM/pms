package pms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pms.entity.PayHouse;

public interface PayHouseMapper {
	List<PayHouse> findAllPay(@Param("ownerName") String ownerName, @Param("ownerPhone") String ownerPhoen,
			@Param("chargeType") Integer chargeType, @Param("payStatus") Integer payStatus,
			@Param("ownerId") Integer ownerId);

	Integer countAllPay(@Param("ownerName") String ownerName, @Param("ownerPhone") String ownerPhoen,
			@Param("chargeType") Integer chargeType, @Param("payStatus") Integer payStatus,
			@Param("ownerId") Integer ownerId);

	void pay(@Param("payId") Integer payId, @Param("payTime") Date payTime);
}
