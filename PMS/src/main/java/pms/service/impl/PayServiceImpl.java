package pms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.entity.Charge;
import pms.entity.Model;
import pms.entity.Pay;
import pms.mapper.ChargeMapper;
import pms.mapper.PayMapper;
import pms.service.PayService;

@Service
public class PayServiceImpl implements PayService {
	@Autowired
	private PayMapper payMapper;

	@Autowired
	private ChargeMapper chargeMapper;

	/**
	 * 此时pay已经有chargeType,houseId以及payUse
	 * 需要通过chargeType查找具体项目，再根据阈值和payUse计算价格存入pay表
	 */
	@Override
	public Model insertPay(Pay pay) {
		// TODO Auto-generated method stub
		Charge charge = chargeMapper.findChargeByChargeType(pay.getChargeType());
		int chargeThreshold = charge.getChargeThreshold();
		int payTotal = 0;
		if (pay.getPayUse() <= chargeThreshold)
			payTotal = pay.getPayUse() * charge.getChargeLow();
		else {
			payTotal = chargeThreshold * charge.getChargeLow()
					+ (pay.getPayUse() - chargeThreshold) * charge.getChargeHigh();
		}
		pay.setPayStatus(0);
		pay.setPayTotal(payTotal);
		payMapper.insertPay(pay);
		Model model = new Model();
		model.setMsg("添加成功");
		return model;
	}

}
