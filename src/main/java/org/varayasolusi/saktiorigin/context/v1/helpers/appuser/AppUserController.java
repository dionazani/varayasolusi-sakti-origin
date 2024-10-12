package org.varayasolusi.saktiorigin.context.v1.helpers.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.varayasolusi.saktiorigin.context.v1.loan.loansimulation.LoanSimulationReqModel;

@RestController
@RequestMapping("v1/app-user")
public class AppUserController {

	@Autowired
	private AppUserService appUserService;
	
	@GetMapping(path= "/{id}", produces = "application/json")
	public ResponseEntity<Object> getAppUserById(@PathVariable("id") String id) {
		ResponseEntity<Object> responseEntity = null;

        try {
        
            var responseModel = this.appUserService.getAppUserById(id);
            responseEntity = ResponseEntity.status(responseModel.getHttpStatusCode())
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(responseModel);

        }
        catch(Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .contentType(MediaType.TEXT_PLAIN)
                                .body(ex.getMessage());
        }

        return responseEntity;
	}
	
}
