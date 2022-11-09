package liga.medical.personservice.core.service;

import liga.medical.personservice.core.annotations.Loggable;
import liga.medical.personservice.core.entity.User;
import liga.medical.personservice.core.repository.UserRepository;
import liga.medical.personservice.core.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Loggable
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if (!Objects.nonNull(user)) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return SecurityUser.fromUser(user);
        }
    }
}