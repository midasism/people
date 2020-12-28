package com.people.service;

import com.people.pojo.Employee;
import com.people.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeServiceImpl service;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        Employee p = service.selectByPrimaryKey(Integer.valueOf(s));
        if (null == p) throw new UsernameNotFoundException("用户名不存在");
        System.out.println(p);
        //将用户名存入session域中
        stringRedisTemplate.opsForValue().set("job_id",s);
        return new User(s,new BCryptPasswordEncoder().encode(p.getPassword()),auths);
    }
}
