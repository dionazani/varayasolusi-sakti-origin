package org.varayasolusi.saktiorigin.context.v1.helpers.appuser;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.varayasolusi.saktiorigin.infrastructure.entity.AppUserEntity;
import org.varayasolusi.saktiorigin.infrastructure.model.ResponseModel;
import org.varayasolusi.saktiorigin.infrastructure.repository.AppUserRepository;
import org.varayasolusi.saktiorigin.utils.commons.FormatUtils;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public ResponseModel getAppUserById(String id) {
		
		Optional<AppUserEntity> appUserEntity = this.appUserRepository.findById(UUID.fromString(id));
		if (appUserEntity.isEmpty()) {
			var responseModel = new ResponseModel();
			responseModel.setHttpStatusCode(404);
			responseModel.setResponseCode("3999");
			responseModel.setResponseMessage("no data found");
			responseModel.setTimeStamp(FormatUtils.getCurrentTimestamp());
			responseModel.setData(null);
			
			return responseModel;
		}
		
		var appUserRespModel = new AppUserRespModel();
		appUserRespModel.setId(id);
		appUserRespModel.setAppUserName(appUserEntity.get().getAppUserName());
		appUserRespModel.setEmail(appUserEntity.get().getEmail());
		appUserRespModel.setMobilePhone(appUserEntity.get().getMobilePhone());
		appUserRespModel.setCreatedAt(appUserEntity.get().getCreatedAt());
		appUserRespModel.setUpdatedAt(appUserEntity.get().getUpdatedAt());
		
		var responseModel = new ResponseModel();
		responseModel.setHttpStatusCode(200);
		responseModel.setResponseCode("1999");
		responseModel.setResponseMessage("success");
		responseModel.setTimeStamp(FormatUtils.getCurrentTimestamp());
		responseModel.setData(appUserRespModel);
		
		return responseModel;
	}

}
