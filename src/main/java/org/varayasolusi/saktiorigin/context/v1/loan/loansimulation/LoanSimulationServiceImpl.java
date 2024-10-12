package org.varayasolusi.saktiorigin.context.v1.loan.loansimulation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.varayasolusi.saktiorigin.infrastructure.model.ResponseModel;
import org.varayasolusi.saktiorigin.utils.commons.FormatUtils;

@Service
public class LoanSimulationServiceImpl implements LoanSimulationService {

	@Autowired
	private LoanSimulationRepositoryCustom simulationRepositoryCustom;
	
	@Override
	public ResponseModel submit(LoanSimulationReqModel simulationReqModel) {
		
		List<ProductOfferingToCalculateSimulationEntity> entities  = this.simulationRepositoryCustom.getProductOfferingToCalculateSimulation(simulationReqModel.getProductOfferingId(),
																								simulationReqModel.getTenour());
		
		if (entities.isEmpty()) {
			var responseModel = new ResponseModel();
			responseModel.setHttpStatusCode(404);
			responseModel.setResponseCode("3999");
			responseModel.setResponseMessage("no data found");
			responseModel.setTimeStamp(FormatUtils.getCurrentTimestamp());
			responseModel.setData(null);
			
			return responseModel;
		}
		
		// calculate fee.
		double adminFee = 0;
		if (entities.get(0).getAdminFeeBehaviour().toUpperCase().equals("A")) {
			adminFee = entities.get(0).getAdminFee();
		}
		
		/* calculate installment. 
		 *  1. convert rate into monthly.
		 *  2. get rateAmount.
		*/
		double loanAmount = simulationReqModel.getLoanAmount();
		double rate = (entities.get(0).getRate()) / 12;
		double rateAmount = (rate/100) * loanAmount;
		double principalDebtAmount = loanAmount / 12;
		double installmentAmount = principalDebtAmount + rateAmount;
		
		double loanAmountNett = loanAmount - adminFee;

		Map map = new HashMap();
		map.put("adminFee", BigDecimal.valueOf(adminFee).setScale(2, RoundingMode.DOWN).toPlainString());
		map.put("installmentAmount", BigDecimal.valueOf(installmentAmount).setScale(2, RoundingMode.DOWN).toPlainString());
		map.put("loanAmountNett", BigDecimal.valueOf(loanAmountNett).setScale(2, RoundingMode.DOWN).toPlainString());
		
		var responseModel = new ResponseModel();
		responseModel.setHttpStatusCode(200);
		responseModel.setResponseCode("1999");
		responseModel.setTimeStamp(FormatUtils.getCurrentTimestamp());
		responseModel.setResponseMessage("success");
		responseModel.setData(map);
		
		return responseModel;
	}

}
