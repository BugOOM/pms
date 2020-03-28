package pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.entity.Charge;
import pms.entity.Model;
import pms.mapper.ChargeMapper;
import pms.service.ChargeService;

@Service
public class ChargeServiceImpl implements ChargeService {
	@Autowired
	private ChargeMapper chargeMapper;

	@Override
	public Model findAllCharges() {
		// TODO Auto-generated method stub
		Model model = new Model();
		List<Charge> list = chargeMapper.findAllCharges();
		model.setCode(0);
		model.setData(list);
		model.setCount(chargeMapper.countAllCharges());
		return model;
	}

	@Override
	public Model updateCharge(Charge charge) {
		// TODO Auto-generated method stub
		Model model = new Model();
		model.setCode(0);
		model.setMsg("修改成功");
		chargeMapper.updateCharge(charge);
		return model;
	}

	@Override
	public void insertCharge(Charge charge) {
		// TODO Auto-generated method stub
		chargeMapper.insertCharge(charge);
	}

}
