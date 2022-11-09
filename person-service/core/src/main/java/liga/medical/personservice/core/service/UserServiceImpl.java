package liga.medical.personservice.core.service;

import liga.medical.personservice.core.entity.Role;
import liga.medical.personservice.core.entity.User;
import liga.medical.personservice.core.service.api.UserService;
//import liga.medical.personservice.core.old.model.Role;
//import liga.medical.personservice.core.old.model.User;
//import liga.medical.personservice.core.old.repository.RoleMapper;
//import liga.medical.personservice.core.old.repository.UserMapper;
import liga.medical.personservice.core.repository.RoleRepository;
import liga.medical.personservice.core.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        setDefaultRole(user);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String login) {
        return userRepository.findByLogin(login);
    }

    private void setDefaultRole(User user) {
        Set<Role> roleSet = new HashSet<>();
        Role role = roleRepository.findRoleByName("ROLE_USER");
        roleSet.add(role);
        user.setRoles(roleSet);
    }
}