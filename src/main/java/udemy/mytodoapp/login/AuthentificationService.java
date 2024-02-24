package udemy.mytodoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {



    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equalsIgnoreCase("Duncan");
        boolean isValidPassword = password.equals("pass");
        return isValidUsername && isValidPassword;
    }

}
