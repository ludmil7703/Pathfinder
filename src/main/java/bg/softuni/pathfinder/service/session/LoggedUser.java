package bg.softuni.pathfinder.service.session;

import org.springframework.stereotype.Component;

@Component
public class LoggedUser {

        private String username;

    private String email;
    private String fullName;

    private boolean isLogged;

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void reset() {
        this.username = null;
        this.email = null;
        this.isLogged = false;
    }
}
