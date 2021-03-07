package jsu.lj.salary.service;

import jsu.lj.salary.pojo.User;
import jsu.lj.salary.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user;
        if (redisTemplate.hasKey(s))
            user = (User) redisTemplate.opsForValue().get(s);
        else
            user = userRepository.findByPhonenum(s);
        if (user == null)
            throw new UsernameNotFoundException("用户名不存在");
        else {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_login");
            authorities.add(grantedAuthority);
            SimpleGrantedAuthority grantedAuthority2;
            if (user.isAdmit())
                grantedAuthority2  = new SimpleGrantedAuthority("ROLE_admit");
            else
                grantedAuthority2 = new SimpleGrantedAuthority("ROLE_user");
            authorities.add(grantedAuthority2);
            redisTemplate.opsForValue().set(s,user);
            return new org.springframework.security.core.userdetails.User(user.getPhonenum(), user.getPassword(), authorities);
        }
    }
}
