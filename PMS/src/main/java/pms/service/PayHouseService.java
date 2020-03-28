package pms.service;

import pms.entity.Model;
import pms.entity.PayHouse;

public interface PayHouseService {
	Model findAllPay(Integer page, Integer limit, String ownerName, String ownerPhoen, Integer chargeType,
			Integer payStatus, Integer ownerId);

	Model reminder(PayHouse payHouse);

	Model pay(Integer payId);
}
