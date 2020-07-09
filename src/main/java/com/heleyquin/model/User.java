package com.heleyquin.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @ManyToMany()
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles;

    public enum StatusType {
        ACTIVE(1), DEACTIVE(0);
        private int value;
        private StatusType(int value) { this.value = value; }

        public int getValue() {
            return value;
        }
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public User(String username, String password, StatusType status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public User(String username, String password, StatusType status, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        for (int i = 0; i < this.roles.size(); i++) {
            Role role = this.roles.get(i);
            if(role.getName().equals("admin")){
                return true;
            }
        }
        return false;
    }
    public boolean isUser() {
        for (int i = 0; i < this.roles.size(); i++) {
            Role role = this.roles.get(i);
            if(role.getName().equals("user")){
                return true;
            }
        }
        return false;
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        HashMap<String, ArrayList<String>> errors = new HashMap<>();
        if (username == null || username.isEmpty()) {
            ArrayList<String> nameErrors = new ArrayList<>();
            if (errors.containsKey("username")) {
                nameErrors = errors.get("username");
            }
            nameErrors.add("Username is required!");
            errors.put("username", nameErrors);
        } else if (username.length() < 5 || username.length() > 20) {
            ArrayList<String> nameErrors = new ArrayList<>();
            if (errors.containsKey("username")) {
                nameErrors = errors.get("username");
            }
            nameErrors.add("Username must be 5 to 20 character!");
            errors.put("username", nameErrors);
        }
        if (password == null || password.isEmpty()) {
            ArrayList<String> passwordErrors = new ArrayList<>();
            if (errors.containsKey("password")) {
                passwordErrors = errors.get("password");
            }
            passwordErrors.add("Password is required!");
            errors.put("password", passwordErrors);
        }else if (password.length() < 5){
            ArrayList<String> passwordErrors = new ArrayList<>();
            if (errors.containsKey("password")) {
                passwordErrors = errors.get("password");
            }
            passwordErrors.add("Password must be more than 5 characters");
            errors.put("password", passwordErrors);
        }
        return errors;
    }
}
