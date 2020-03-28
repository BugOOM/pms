package pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.Model;
import pms.service.DeptHouseService;

@Controller
@RequestMapping("/deptHouse")
public class DeptHouseController {
	@Autowired
	private DeptHouseService deptHouseService;

	@RequestMapping("/findDeptHouse")
	@ResponseBody
	public Model findDept(Integer deptId, @RequestParam(value = "page", defaultValue = "10") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit, String houseNum, String ownerName,
			String ownerPhone) {

		Model model = deptHouseService.findDeptHouse(deptId, houseNum, ownerName, ownerPhone, page, limit);
		return model;
	}

	@RequestMapping("/findUserDeptHouse")
	@ResponseBody
	public Model findDept(Integer deptId, @RequestParam(value = "page", defaultValue = "10") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit, String houseNum) {

		Model model = deptHouseService.findUserDeptHouse(deptId, houseNum, page, limit);
		return model;
	}
}
