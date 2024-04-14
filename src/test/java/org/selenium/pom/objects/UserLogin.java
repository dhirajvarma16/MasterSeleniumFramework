package org.selenium.pom.objects;

public class UserLogin {
    private String username;
    private String password;
    private String email;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserLogin() {
    }

    public String getUsername() {
        return username;
    }

    public UserLogin setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLogin setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserLogin setEmail(String email){
        this.email=email;
        return this;
    }

    public String getEmail(){
        return email;
    }
}
