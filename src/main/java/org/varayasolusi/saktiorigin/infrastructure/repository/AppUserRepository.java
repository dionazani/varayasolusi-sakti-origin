package org.varayasolusi.saktiorigin.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.varayasolusi.saktiorigin.infrastructure.entity.AppUserEntity;

@Repository
public interface AppUserRepository extends CrudRepository<AppUserEntity, UUID>{

}
