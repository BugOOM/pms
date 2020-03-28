package pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.Model;
import pms.entity.Pay;
import pms.service.PayService;

@Controller
@RequestMapping("/pay")
public class PayController {
	@Autowired
	private PayService payService;

	@RequestMapping("/fee")
	@ResponseBody
	public Model insertPay(Pay pay) {
		return payService.insertPay(pay);
	}
}
