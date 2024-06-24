package com.thoma.finmanapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Party extends BaseEntity {

    @Column
    String partyId;

    @Column
    String name;

    @Column
    String description;

    public String getPartyId() {
        return this.partyId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
