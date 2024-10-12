package org.varayasolusi.saktiorigin.context.v1.loan.loansimulation;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProductOfferingToCalculateSimulationEntity {

	@Id
	private UUID productOfferingId;
	private UUID productOfferingKtaId;
	private String productOfferingKtaDescription;
	private UUID productBranchId;
	private int tenourTo;
	private double rate;
	private String rateType;
	private String branchDescription;
	private UUID productKtaFeeId;
	private String adminFeeBehaviour;
	private double adminFee;
	private String provisionFeeBehaviour;
	private String provisionFee;
}
