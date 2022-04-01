package org.harryng.demo.quarkus.user.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_")
public class UserImplBak {//extends UserModel {

    //    public UserImpl(Long id, LocalDateTime createdDate, LocalDateTime modifiedDate, String status,
//                    String username, String password, String screenName, LocalDate dob, String passwdEncryptedMethod) {
//        super(id, createdDate, modifiedDate, status, username, password, screenName, dob, passwdEncryptedMethod);
//    }
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String status;

    private String username;
    private String password;
    private String screenName;
    private LocalDate dob;
    private String passwdEncryptedMethod;

    public UserImplBak(){}

    public UserImplBak(Long id, LocalDateTime createdDate, LocalDateTime modifiedDate, String status,
                       String username, String password, String screenName, LocalDate dob, String passwdEncryptedMethod) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.username = username;
        this.password = password;
        this.screenName = screenName;
        this.dob = dob;
        this.passwdEncryptedMethod = passwdEncryptedMethod;
    }

    @Id
    @Column(name = "id_")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "created_date")
//    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "modified_date")
//    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "screenname")
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Basic
    @Column(name = "dob")
//    @Temporal(TemporalType.DATE)
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "passwd_enc_method")
    public String getPasswdEncryptedMethod() {
        return passwdEncryptedMethod;
    }

    public void setPasswdEncryptedMethod(String passwdEncryptedMethod) {
        this.passwdEncryptedMethod = passwdEncryptedMethod;
    }
}
