package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.entity.User;

public interface UserValidator {
    boolean isUserValid(User user);

    boolean isUserExist(User user);
}
