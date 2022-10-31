package liga.medical.personservice.core.model;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private Long id;

    private String login;

    private String password;

    private Set<Role> roles;

}
