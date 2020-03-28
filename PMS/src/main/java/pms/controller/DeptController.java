package pms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.Dept;
import pms.entity.Model;
import pms.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private DeptService deptService;

	@RequestMapping("/add")
	@ResponseBody
	public Model model(Dept dept) {
		deptService.insertDept(dept);
		Model model = new Model();
		model.setCode(0);
		model.setMsg("添加成功");
		return model;
	}

	@RequestMapping("/findDept")
	@ResponseBody
	public Model findDept(Integer deptId, @RequestParam(value = "page", defaultValue = "10") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit) {

		Model model = deptService.findDept(deptId, page, limit);
		return model;
	}

	@RequestMapping("/findFloor")
	@ResponseBody
	public List<Integer> findFloor(Integer deptId) {
		int floor = deptService.findFloor(deptId);
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= floor; i++)
			list.add(i);
		return list;
	}
}
