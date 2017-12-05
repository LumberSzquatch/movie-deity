package movieDeity.domain.model.forms;

import movieDeity.Constants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm {

    @NotNull(message = "Must enter a username")
    @Size(min = 8, max = 12, message = "Username must be between 8 and 12 characters")
    @Pattern(regexp = Constants.USERNAME_REGEX, message = "Username can only contain letters and numbers")
    private String username;
    @NotNull(message = "Must enter a password")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    @NotNull(message = "Passwords do not match. Try again")
    private String confirmPassword;
    @Pattern(regexp = Constants.EMAIL_REGEX, message = "Email format is invalid. Please enter a valid email")
    private String email;

    public UserForm(){}

    public UserForm(String username, String password, String firstName, String lastName, String email){
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        checkPassword();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void checkPassword() {
        if(this.password == null || this.confirmPassword == null){
            return;
        }
        if(!this.password.equals(confirmPassword)){
            this.confirmPassword = null;
        }
    }
}
