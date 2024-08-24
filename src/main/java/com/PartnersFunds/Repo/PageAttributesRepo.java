package com.PartnersFunds.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PartnersFunds.Entities.PageAttributesEntity;
import com.PartnersFunds.Entities.PagesEntity;

@Repository
public interface PageAttributesRepo extends JpaRepository<PageAttributesEntity, Integer> {
	
	@Query(value = "select * from xxpf_page_attributes xp where xp.attribute_id = :attribute_id", nativeQuery = true)
	PageAttributesEntity findByattribute_id(@Param("attribute_id") int attribute_id);
	
//    @Query(value = "SELECT * FROM xxpf_page_attributes xp WHERE xp.page_id = :page_id AND xp.attribute_id IN :attributeIds", nativeQuery = true)
//    List<PageAttributesEntity> findAllByAttributeIds(@Param("page_id") int page_id,@Param("attributeIds") List<Integer> attributeIds);
    
	@Query(value = "SELECT xp.attribute_id, xp.property_value FROM xxpf_page_attr_properties xp "
			+ "WHERE xp.attribute_id IN :attributeIds " + "AND xp.property_name = 'eovo'", nativeQuery = true)
	List<Object[]> findAllEOVOByAttributeIds(@Param("attributeIds") List<Integer> attributeIds);
}
