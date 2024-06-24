package com.thoma.finmanapi.entity;

import jakarta.persistence.Entity;

@Entity
public class UserEntity extends BaseEntity {

    String username;
    String name;
    String description;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
