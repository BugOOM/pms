package pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.AdminModel;
import pms.entity.SysUser;
import pms.service.MailService;
import pms.service.UserService;

@Controller
public class MailController {
	@Autowired
	private MailService mailService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping("/email")
	@ResponseBody
	public AdminModel send(String email) {
		AdminModel model = new AdminModel();
		SysUser user = userService.findUserByEmail(email);

		if (user == null) {
			model.setCode(1);
			model.setMsg("抱歉，未找到相关用户");
		} else {
			model.setCode(0);
			mailService.sendSimpleMail(email, "变更密码", "将您的默认密码设置为预留邮箱，直接登录即可");
			userService.updatePassword(user.getUsername(), passwordEncoder.encode(email));
			model.setMsg("包含相关信息的邮件已经发送到你的邮箱");
		}

		return model;
	}
}
