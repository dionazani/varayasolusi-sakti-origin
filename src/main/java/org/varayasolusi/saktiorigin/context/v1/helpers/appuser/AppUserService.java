package org.varayasolusi.saktiorigin.context.v1.helpers.appuser;

import org.springframework.stereotype.Service;
import org.varayasolusi.saktiorigin.infrastructure.model.ResponseModel;

public interface AppUserService {

	public ResponseModel getAppUserById(String id);
}
