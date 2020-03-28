package pms.mapper;

import pms.entity.Pay;

public interface PayMapper {
	void insertPay(Pay pay);

	Pay findPayByPayId(Integer PayId);
}
