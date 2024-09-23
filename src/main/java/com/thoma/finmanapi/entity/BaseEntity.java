package com.thoma.finmanapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    boolean isActive;

    @Column
    ZonedDateTime createdAt;

    @Column
    ZonedDateTime modifiedAt;

    @Column
    boolean isDeleted;

    @Column
    String createdBy;

    @Column
    String lastModifiedBy;

    public BaseEntity() {
        isActive = true;
        isDeleted = false;
        createdAt = ZonedDateTime.now();
        modifiedAt = ZonedDateTime.now();
    }

    public Long getId() {
        return this.id;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public ZonedDateTime getCreatedAt() {
        return this.createdAt;
    }

    public ZonedDateTime getModifiedAt() {
        return this.modifiedAt;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(ZonedDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
