//developed by Vladyslav Haponenko
package model.User;

import lombok.*;
import org.springframework.data.annotation.Id;
import com.scriptizergs.ribenteuer.security.models.Role;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String mail;
    private String password;
    private String login;
    private Role activeRole;

    public User(String mail, String pass, String login, Role activeRole) {
        this.mail = mail;
        this.password = pass;
        this.login = login;
        this.activeRole = activeRole;
    }

}
