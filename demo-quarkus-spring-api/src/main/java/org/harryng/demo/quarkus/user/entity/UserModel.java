package org.harryng.demo.quarkus.user.entity;

import org.harryng.demo.quarkus.base.entity.AbstractStatedEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserModel extends AbstractStatedEntity<Long> {

    private String username;
    private String password;
    private String screenName;
    private LocalDate dob;
    private String passwdEncryptedMethod;

    public UserModel(Long id, LocalDateTime createdDate, LocalDateTime modifiedDate, String status,
                     String username, String password, String screenName, LocalDate dob, String passwdEncryptedMethod){
        super(id, createdDate, modifiedDate, status);
        this.username = username;
        this.password = password;
        this.screenName = screenName;
        this.dob = dob;
        this.passwdEncryptedMethod = passwdEncryptedMethod;
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

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPasswdEncryptedMethod() {
        return passwdEncryptedMethod;
    }

    public void setPasswdEncryptedMethod(String passwdEncryptedMethod) {
        this.passwdEncryptedMethod = passwdEncryptedMethod;
    }
}
