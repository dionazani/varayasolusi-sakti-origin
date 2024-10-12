package org.varayasolusi.saktiorigin.context.v1.loan.loansimulation;

import org.springframework.stereotype.Service;
import org.varayasolusi.saktiorigin.infrastructure.model.ResponseModel;

@Service
public interface LoanSimulationService {

	ResponseModel submit(LoanSimulationReqModel simulationReqModel);
}
