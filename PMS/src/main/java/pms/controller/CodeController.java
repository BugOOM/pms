package pms.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Producer;

import pms.utils.Scaptcha;

@Controller
public class CodeController {
	@Autowired
	private Producer producer;

	@RequestMapping(value = "/user/code", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public void verification(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 实例生成验证码对象
		Scaptcha instance = new Scaptcha();
		// 将验证码存入session
		session.setAttribute("code", instance.getCode());
		// 向页面输出验证码图片
		instance.write(response.getOutputStream());
	}

	@RequestMapping(value = "/image/code", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public void verification1(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String capText = producer.createText();
		session.setAttribute("verification", capText);

		BufferedImage bi = producer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		// 向页面输出验证码图片

	}
}
