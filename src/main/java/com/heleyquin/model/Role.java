package com.heleyquin.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<User> users;
    private int Role;

    public Role(String name) {
        this.name = name;
    }

    public boolean isUser() {
        return this.Role == role.USER.getValue();
    }

    public boolean isAdmin() {
        return this.Role == role.ADMIN.getValue();
    }

    public boolean isMember() {
        return (this.isUser() || this.isAdmin());
    }

    public enum role {
        USER(1), ADMIN(2);

        private int value;

        role(int value) {
            this.value = value;
        }

        public static role findByValue(int value) {
            for (role r : role.values()) {
                if (r.value == value) {
                    return r;
                }
            }
            return role.USER;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}

