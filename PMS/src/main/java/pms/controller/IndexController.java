package pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value = { "/", "/start" })
	public String toIndex(HttpSession session) {
		Object obj = session.getAttribute("user");
		if (obj == null)
			return "redirect:/login/index.html";
		else
			return "redirect:/start/user.html";
	}
}
