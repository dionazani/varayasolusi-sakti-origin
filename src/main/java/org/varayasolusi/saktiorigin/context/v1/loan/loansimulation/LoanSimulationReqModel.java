package org.varayasolusi.saktiorigin.context.v1.loan.loansimulation;

import lombok.Data;

@Data
public class LoanSimulationReqModel {

	public String productOfferingId;
	public int tenour;
	public double loanAmount;
}
