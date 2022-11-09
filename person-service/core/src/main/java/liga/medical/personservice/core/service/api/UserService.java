package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String login);

}