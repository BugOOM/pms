package pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.AdminModel;
import pms.entity.Model;
import pms.entity.PayHouse;
import pms.service.PayHouseService;

@Controller
@RequestMapping("/payHouse")
public class PayHouseController {
	@Autowired
	private PayHouseService payHouseService;

	@RequestMapping("/findAll")
	@ResponseBody
	public Model findAll(@RequestParam(value = "page", defaultValue = "10") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit, String ownerName, String ownerPhone,
			Integer chargeType, Integer payStatus, Integer ownerId) {
		return payHouseService.findAllPay(page, limit, ownerName, ownerPhone, chargeType, payStatus, ownerId);
	}

	@RequestMapping("/userFindAll")
	@ResponseBody
	public Model userFindAll(@RequestParam(value = "page", defaultValue = "10") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit, String ownerName, String ownerPhone,
			Integer chargeType, Integer payStatus, HttpSession session) {
		Integer ownerId = ((AdminModel) session.getAttribute("user")).getData().getOwnerId();
		return payHouseService.findAllPay(page, limit, ownerName, ownerPhone, chargeType, payStatus, ownerId);
	}

	@RequestMapping("/remainder")
	@ResponseBody
	public Model reminder(PayHouse payHouse) {
		return payHouseService.reminder(payHouse);
	}

	@RequestMapping("/pay")
	@ResponseBody
	public Model pay(Integer payId) {
		return payHouseService.pay(payId);
	}
}
