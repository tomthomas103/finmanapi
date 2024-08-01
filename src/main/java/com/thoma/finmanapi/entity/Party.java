package com.thoma.finmanapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Party extends BaseEntity {

    @Column
    String partyId;

    @Column
    String name;

    @Column
    String description;

}
