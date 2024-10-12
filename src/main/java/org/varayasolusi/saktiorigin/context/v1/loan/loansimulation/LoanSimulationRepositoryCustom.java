package org.varayasolusi.saktiorigin.context.v1.loan.loansimulation;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LoanSimulationRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	public List<ProductOfferingToCalculateSimulationEntity> getProductOfferingToCalculateSimulation(String productOfferingId,
																	int tenourTo) {
		
		String sql = "select po.id as product_offering_id,\r\n"
				+ "		po.description as product_offering_description,\r\n"
				+ "		pok.id as product_offering_kta_id,\r\n"
				+ "		pok.description as product_offering_kta_description,\r\n"
				+ "		po.branch_id as product_branch_id,\r\n"
				+ "		pok.tenour_to,\r\n"
				+ "		pok.rate,\r\n"
				+ "		pok.rate_type,\r\n"
				+ "		b.description as branch_description,\r\n"
				+ "		pkf.id as product_kta_fee_id,\r\n"
				+ "		pkf.admin_fee_behaviour,\r\n"
				+ "		pkf.admin_fee,\r\n"
				+ "		pkf.provision_fee_behaviour,\r\n"
				+ "		pkf.provision_fee\r\n"
				+ "from product p inner join product_offering po on po.product_id = p.id \r\n"
				+ "		inner join product_offering_kta pok on pok.product_offering_id = po.id\r\n"
				+ "		inner join branch b on b.id = po.branch_id\r\n"
				+ "		inner join product_kta_fee pkf on pkf.product_id = p.id \r\n"
				+ "where po.id = :productOfferingId \r\n"
				+ "		and pok.tenour_to >= :tenourTo \r\n"
				+ "order by pok.tenour_to \r\n"
				+ "limit 1";
		
		List<ProductOfferingToCalculateSimulationEntity> entities = this.em.createNativeQuery(sql, ProductOfferingToCalculateSimulationEntity.class)
																		.setParameter("productOfferingId", UUID.fromString(productOfferingId))
																		.setParameter("tenourTo", tenourTo)
																		.getResultList();
		return entities;
	}
}
