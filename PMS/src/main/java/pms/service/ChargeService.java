package pms.service;

import pms.entity.Charge;
import pms.entity.Model;

public interface ChargeService {
	Model findAllCharges();

	Model updateCharge(Charge charge);

	void insertCharge(Charge charge);
}
