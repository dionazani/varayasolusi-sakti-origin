package org.varayasolusi.saktiorigin.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.varayasolusi.saktiorigin.infrastructure.entity.ProductOfferingEntity;

@Repository
public interface ProductOfferingRepository extends JpaRepository<ProductOfferingEntity, UUID>{

	
}
