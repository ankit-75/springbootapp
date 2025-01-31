//package com.example.demo.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.EntityListeners;
//import jakarta.persistence.MappedSuperclass;
//import org.springframework.data.annotation.CreatedBy;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedBy;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import java.time.LocalDateTime;
//
//@EntityListeners(AuditingEntityListener.class)
//@MappedSuperclass
//public abstract class Auditing {
//    @CreatedBy
//    protected String createdBy;
//
//    @CreatedDate
//    @Column(nullable = true, updatable = false)
//    protected LocalDateTime createdDate;
//
//    @LastModifiedBy
//    protected String lastModifiedBy;
//
//    @LastModifiedDate
//    protected LocalDateTime lastModifiedDate;
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public String getLastModifiedBy() {
//        return lastModifiedBy;
//    }
//
//    public void setLastModifiedBy(String lastModifiedBy) {
//        this.lastModifiedBy = lastModifiedBy;
//    }
//
//    public LocalDateTime getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//}
