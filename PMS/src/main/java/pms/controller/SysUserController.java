package pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.AdminModel;
import pms.entity.Model;
import pms.entity.Owner;
import pms.entity.OwnerModel;
import pms.entity.SysUser;
import pms.service.UserService;

@Controller
@RequestMapping("/sys")
public class SysUserController {
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping("/code")
	@ResponseBody
	public String code(HttpSession session, String code) {
		String c = (String) session.getAttribute("code");
		if (c.equals(code))
			return "true";
		return "false";
	}

	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session) {
		return "forward:/login/login.html";
	}

	@RequestMapping("/register")
	@ResponseBody
	public Model register(String username, String password, String email) {
		SysUser user = userService.findUserByUsername(username);
		Model model = new Model();
		if (user != null) {
			model.setCode(1);
			model.setMsg("抱歉，该用户名已被使用");
		} else {
			SysUser sysUser = new SysUser();
			sysUser.setUsername(username);
			sysUser.setPassword(passwordEncoder.encode(password));
			sysUser.setEmail(email);
			userService.insertUser(sysUser);
			model.setCode(0);
			model.setMsg("注册成功,为您跳转至登录界面");
		}
		return model;
	}

	@RequestMapping("/getUser")
	@ResponseBody
	public AdminModel getUser(HttpSession session) {
		return (AdminModel) session.getAttribute("user");
	}

	@RequestMapping("/getPeople")
	@ResponseBody
	public OwnerModel getPeople(HttpSession session) {
		Integer id = ((AdminModel) session.getAttribute("user")).getData().getOwnerId();
		Owner owner = new Owner();
		if (id != null)
			owner = userService.selectOwnerById(id);
		OwnerModel model = new OwnerModel();
		model.setCode(0);
		model.setData(owner);
		return model;
	}

	@RequestMapping("/changePwd")
	@ResponseBody
	public AdminModel changePwd(String oldPassword, String password, HttpSession session) {
		AdminModel model = new AdminModel();
		String loginUserName = ((AdminModel) session.getAttribute("user")).getData().getUsername();
		SysUser user = userService.findUserByUsername(loginUserName);
		if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
			model.setCode(1);
			model.setMsg("抱歉，你的原始密码不对哦");
		} else {
			String encryptedPassword = passwordEncoder.encode(password);
			userService.updatePassword(loginUserName, encryptedPassword);
			model.setCode(0);
			model.setMsg("更新密码成功，请重新登录");
		}

		return model;
	}
}
