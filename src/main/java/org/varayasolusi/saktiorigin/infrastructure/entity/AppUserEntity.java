package org.varayasolusi.saktiorigin.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name="app_user")
public class AppUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;

    @CreationTimestamp
    @Column(name="created_at")
    private Timestamp createdAt;
    
    private Timestamp updatedAt;
    
	private String email;

	private String mobilePhone;
	
	private String appUserName;
}
