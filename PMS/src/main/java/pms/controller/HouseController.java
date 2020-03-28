package pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.AdminModel;
import pms.entity.Model;
import pms.service.HouseService;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Autowired
	private HouseService houseService;

	@RequestMapping("/update")
	@ResponseBody
	public Model update(Integer houseId, HttpSession session) {
		Model model = new Model();
		Integer ownerId = ((AdminModel) session.getAttribute("user")).getData().getOwnerId();
		houseService.updateHouse(houseId, ownerId);
		model.setCode(0);
		model.setMsg("入住成功！");
		return model;
	}
}
