package com.PartnersFunds.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PartnersFunds.Entities.pageAttributesEntity;
import com.PartnersFunds.Entities.pagesEntity;

@Repository
public interface pageAttributesRepo extends JpaRepository<pageAttributesEntity, Integer> {
	@Query(value = "select * from xxpf_page_attributes xp where xp.attribute_id = :attribute_id", nativeQuery = true)
	pageAttributesEntity findByattribute_id(@Param("attribute_id") int attribute_id);
}
