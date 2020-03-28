package pms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pms.entity.SysRole;
import pms.entity.SysUser;
import pms.mapper.UserMapper;

@Service
public class SysUserService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		SysUser user = userMapper.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		List<GrantedAuthority> auth = new ArrayList<>();
		List<SysRole> roles = user.getRoles();
		for (SysRole role : roles)
			auth.add(new SimpleGrantedAuthority(role.getName()));
		return new User(user.getUsername(), user.getPassword(), auth);
	}

}
