package org.varayasolusi.saktiorigin.infrastructure.entity;


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
@Table(name="product_offering_kta")
public class ProductOfferingKtaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
	public java.util.UUID id;
    
	public java.util.UUID productOfferingId;
	public String code;
	public String description;
	public short tenourFrom;
	public short tenourTo;
	public java.math.BigDecimal loanFrom;
	public java.math.BigDecimal loanTo;
	public java.math.BigDecimal rate;
	public java.math.BigDecimal dsr;
	public short gracePeriod;
	public short isRepaymentExist;
	public java.math.BigDecimal lateChargePercentage;
	public java.math.BigDecimal maxLateFeeInstallmentPercentage;
	public java.math.BigDecimal repaymentChargePercentage;
	public int creditScoreMin;
	public int maxProcessInDay;
	public String debtorType;
	public java.util.UUID repaymentSchemaId;
	public String rateType;
	
    @CreationTimestamp
	public java.sql.Timestamp createdAt;
    
	public java.sql.Timestamp updatedAt;
	public java.util.UUID createdUserId;
	public java.util.UUID updatedUserId;
}
