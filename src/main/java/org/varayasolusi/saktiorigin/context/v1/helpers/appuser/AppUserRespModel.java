package org.varayasolusi.saktiorigin.context.v1.helpers.appuser;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AppUserRespModel {

    private String id;

    private Timestamp createdAt;
    
    private Timestamp updatedAt;
    
	private String email;

	private String mobilePhone;
	
	private String appUserName;
}
