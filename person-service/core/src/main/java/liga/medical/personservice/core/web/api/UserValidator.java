package liga.medical.personservice.core.web.api;

import liga.medical.personservice.core.model.User;

public interface UserValidator {
    boolean isUserValid(User user);

    boolean isUserExist(User user);
}
