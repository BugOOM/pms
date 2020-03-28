package pms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import pms.entity.AdminModel;
import pms.entity.SysUser;
import pms.service.UserService;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails details = (UserDetails) auth.getPrincipal();
		SysUser sysUser = userService.findUserByUsername(details.getUsername());
		AdminModel model = new AdminModel();
		model.setCode(0);
		model.setData(sysUser);
		request.getSession().setAttribute("user", model);
		if (details.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
			response.getWriter().write("admin");
		else
			response.getWriter().write("user");
	}
}
