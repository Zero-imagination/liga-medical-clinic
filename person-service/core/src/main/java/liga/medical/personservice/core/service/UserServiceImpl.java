package liga.medical.personservice.core.service;

import liga.medical.personservice.core.repository.RolesUserMapper;
import liga.medical.personservice.core.api.UserService;
import liga.medical.personservice.core.model.Role;
import liga.medical.personservice.core.model.User;
import liga.medical.personservice.core.repository.RoleMapper;
import liga.medical.personservice.core.repository.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final RoleMapper roleMapper;

    private final RolesUserMapper rolesUserMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserMapper userMapper, RoleMapper roleMapper, RolesUserMapper rolesUserMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.rolesUserMapper = rolesUserMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapper.save(user);
        User userWithId = userMapper.getUserByUsername(user.getLogin());
        setDefaultRole(userWithId);
        for (Role role: userWithId.getRoles()) {
            rolesUserMapper.save(userWithId.getId(), role.getId());
        }

    }

    @Override
    public User findByUsername(String login) {
        return userMapper.getUserByUsername(login);
    }

    private void setDefaultRole(User user) {
        Set<Role> roleSet = new HashSet<>();
        Role role = roleMapper.findByName("ROLE_USER");
        roleSet.add(role);
        user.setRoles(roleSet);
    }
}