package liga.medical.personservice.core.web;

import liga.medical.personservice.core.repository.UserRepository;
import liga.medical.personservice.core.service.api.UserValidator;
import liga.medical.personservice.core.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

    private final UserRepository userRepository;

    public UserValidatorImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        return userRepository.findByLogin(user.getLogin()) != null;
    }
}
