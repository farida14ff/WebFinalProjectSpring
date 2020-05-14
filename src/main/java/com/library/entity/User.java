package com.library.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Bean;

@Entity
public class User {

    @Id
    @Column(unique = true)
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "departament")
    private String departament;
    @Size(min = 4)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Retrievement> retrievements;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns={
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name") })
    private List<Role> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Retrievement> getRetrievements() {
        return retrievements;
    }

    public void setRetrievements(List<Retrievement> retrievements) {
        this.retrievements = retrievements;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}