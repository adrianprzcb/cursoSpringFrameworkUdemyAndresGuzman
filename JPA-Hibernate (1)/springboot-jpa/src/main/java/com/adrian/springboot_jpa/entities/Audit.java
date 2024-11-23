package com.adrian.springboot_jpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class Audit {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


        @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
        System.out.println("Before saving the object");
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
        System.out.println("Before updating the object");
    }


    

}
