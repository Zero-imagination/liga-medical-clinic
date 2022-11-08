package liga.medical.personservice.core.web;

import liga.medical.personservice.core.api.UserValidator;
import liga.medical.personservice.core.model.User;
import liga.medical.personservice.core.repository.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

    private final UserMapper userMapper;

    public UserValidatorImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean isUserValid(User user) {
        if (user.getLogin() == null || user.getPassword() == null) {
            return false;
        }
        if (user.getLogin().length() < 8 || user.getPassword().length() < 8) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isUserExist(User user) {
        return userMapper.getUserByUsername(user.getLogin()) != null;
    }
}
