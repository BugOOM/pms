package pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.Charge;
import pms.entity.Model;
import pms.service.ChargeService;

@Controller
@RequestMapping("/charge")
public class ChargeController {
	@Autowired
	private ChargeService chargeService;

	@RequestMapping("/findAll")
	@ResponseBody
	public Model findAll() {
		return chargeService.findAllCharges();
	}

	@RequestMapping("/update")
	@ResponseBody
	public Model update(Charge charge) {
		return chargeService.updateCharge(charge);
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Model insert(Charge charge) {
		Model model = new Model();
		chargeService.insertCharge(charge);
		model.setCode(0);
		model.setMsg("添加成功");
		return model;
	}

}
