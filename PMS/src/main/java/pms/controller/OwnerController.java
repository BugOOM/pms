package pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.AdminModel;
import pms.entity.Model;
import pms.entity.Owner;
import pms.entity.SysUser;
import pms.service.OwnerService;
import pms.service.UserService;

@Controller
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;

	@Autowired
	private UserService userService;

	@RequestMapping("/findAll")
	@ResponseBody
	public Model findAll() {
		Model model = new Model();
		model.setCode(0);
		model.setData(ownerService.findAll());
		model.setCount(ownerService.total());
		return model;
	}

	@RequestMapping("/setinfo")
	@ResponseBody
	public Model setinfo(Owner owner, HttpSession session, String email) {
		SysUser user = ((AdminModel) session.getAttribute("user")).getData();
		user.setEmail(email);
		userService.updateEmail(user);
		if (user.getOwnerId() != null)
			ownerService.updateOwner(owner, user);
		else {
			ownerService.insertOwner(owner, user);
			user.setOwnerId(owner.getOwnerId());
		}
		Model model = new Model();
		model.setCode(0);
		model.setMsg("修改成功");
		return model;
	}
}
