package pms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pms.service.impl.SysUserService;

/**
 * 自定义Spring Security认证处理类的时候 我们需要继承自WebSecurityConfigurerAdapter来完成，相关配置重写对应
 * 方法即可。
 */
@Configuration
@EnableWebSecurity // 注解开启Spring Security的功能
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启spring security注解功能
public class SysSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	SysUserService sysUserService;

	@Autowired
	LoginSuccessHandler loginSuccessHandler;

	/**
	 * 设置了登录页面，而且登录页面任何人都可以访问，然后设置了登录失败地址，也设置了注销请求，注销请求也是任何人都可以访问的。
	 * permitAll表示该请求任何人都可以访问，.anyRequest().authenticated(),表示其他的请求都必须要有权限认证。
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/sys/login", "/sys/register", "/email", "/*/code", "/login/register.html",
						"/login/forget.html")
				.permitAll().antMatchers("/start/user.html/**").hasRole("USER").antMatchers("/start/admin.html/**")
				.hasRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/sys/login")
				.successHandler(loginSuccessHandler).permitAll().usernameParameter("username")
				.passwordParameter("password").and().logout().permitAll().and().csrf().disable();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**/*.css", "/**/*.js", "/**/font/**");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(sysUserService).passwordEncoder(passwordEncoder());
		// 添加我们自定义的user Detail service认证
	}

}
