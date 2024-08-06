package com.PartnersFunds.Repo;

import com.PartnersFunds.Entities.ExpressionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpressionRepo extends JpaRepository<ExpressionEntity, Long> {
	
	@Query(value="select EXPRESSION_NAME from XXPF_EXPRESSIONS where EXPRESSION_ID = :exp_id",nativeQuery=true)
	String ExpNameQuery(@Param("exp_id") int exp_id);
}
