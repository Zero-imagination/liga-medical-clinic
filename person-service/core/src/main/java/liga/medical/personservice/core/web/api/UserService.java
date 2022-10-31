package liga.medical.personservice.core.web.api;

import liga.medical.personservice.core.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String login);

}