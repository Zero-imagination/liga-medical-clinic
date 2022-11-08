package liga.medical.personservice.core.service;

import liga.medical.personservice.core.annotations.Loggable;
import liga.medical.personservice.core.repository.UserMapper;
import liga.medical.personservice.core.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    public UserDetailsServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Loggable
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!Objects.nonNull(userMapper.getUserByUsername(username))) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return SecurityUser.fromUser(userMapper.getUserByUsername(username));
        }
    }
}