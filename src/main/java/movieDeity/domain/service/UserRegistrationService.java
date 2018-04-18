package movieDeity.domain.service;

import movieDeity.interfaces.user.RegistrationService;
import org.springframework.stereotype.Service;

@Service("registrationService")
public class UserRegistrationService implements RegistrationService {

    String testTaken = "1";

    @Override
    public boolean usernameExists(String username) {
        //Temp validation
        if (username.contains(testTaken)) {
            return true;
        }
        return false;
    }
}
