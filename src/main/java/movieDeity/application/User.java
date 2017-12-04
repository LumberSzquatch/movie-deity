package movieDeity.application;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class User {

    @NotEmpty(message = "Must enter a username")
    @Size(min = 8, max = 12, message = "Username must be between 8 and 12 characters")
    private String username;
    @NotEmpty(message = "Must enter a password")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    private String email;

    public User(){}

    public User(String username, String password, String firstName, String lastName, String email){
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
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
