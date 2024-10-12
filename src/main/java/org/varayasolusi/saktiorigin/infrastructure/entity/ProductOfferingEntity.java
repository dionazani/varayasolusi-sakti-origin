package org.varayasolusi.saktiorigin.infrastructure.entity;

import java.sql.Timestamp;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product_offering")
public class ProductOfferingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;
    
    private UUID productId;
    
    private String code;
    
    private String description;
    
    private UUID branchId;
    
    private short isActive;
    
    @CreationTimestamp
    @Column(name="created_at")
    private Timestamp createdAt;
    
    private Timestamp updateAt;
    
    private UUID createdUserId;
    
    private UUID updatedUserId;
}
