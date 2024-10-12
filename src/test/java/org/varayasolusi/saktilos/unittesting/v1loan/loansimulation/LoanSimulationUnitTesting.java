package org.varayasolusi.saktilos.unittesting.v1loan.loansimulation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.varayasolusi.saktiorigin.context.v1.loan.loansimulation.LoanSimulationReqModel;
import org.varayasolusi.saktiorigin.context.v1.loan.loansimulation.LoanSimulationService;

@SpringBootTest
public class LoanSimulationUnitTesting {

	@Autowired
	private LoanSimulationService simulationService;
	
	@Test
	public void testSimulationSubmit() {
		var simulationReqModel = new LoanSimulationReqModel();
		simulationReqModel.setProductOfferingId("050e610e-bf6f-49c1-8a56-09d28a1e363c");
		simulationReqModel.setLoanAmount(10000000);
		simulationReqModel.setTenour(12);
		
		var responseModel = simulationService.submit(simulationReqModel);
		
		assertThat(responseModel).isNotNull();
	}
}
