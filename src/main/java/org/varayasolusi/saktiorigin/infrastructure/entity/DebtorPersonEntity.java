package org.varayasolusi.saktiorigin.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="debtor_person")
public class DebtorPersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
	public java.util.UUID id;
    
	public java.util.UUID debtorId;
	public String fullName;
	public String email;
	public String identityNumber;
	public String mobilePhone;
	public String npwpNumber;
	public String gender;
	public String pob;
	public java.sql.Date dob;
	public String motherName;
	public java.sql.Timestamp createdAt;
	public java.sql.Timestamp updatedAt;
	public java.util.UUID createdUserId;
	public java.util.UUID updatedUserId;
}
