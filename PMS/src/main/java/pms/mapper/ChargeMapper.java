package pms.mapper;

import java.util.List;

import pms.entity.Charge;

public interface ChargeMapper {
	List<Charge> findAllCharges();

	Integer countAllCharges();

	void updateCharge(Charge charge);

	void insertCharge(Charge charge);

	Charge findChargeByChargeType(Integer chargeType);
}
