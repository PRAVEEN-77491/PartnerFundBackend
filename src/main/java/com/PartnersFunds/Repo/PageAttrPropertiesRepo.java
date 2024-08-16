package com.PartnersFunds.Repo;

import com.PartnersFunds.Entities.PageAttrPropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PageAttrPropertiesRepo extends JpaRepository<PageAttrPropertiesEntity, Integer> {
   @Query(
      value = "select property_value from xxpf_page_attr_properties where property_name = 'ONCLICK' AND attribute_id = :attr_id ",
      nativeQuery = true
   )
   String dBFuncName(@Param("attr_id") int attr_id);

   @Query(
        value = "SELECT * FROM xxpf_page_attr_properties WHERE attribute_id = :attr_id AND property_name = :property_name",
        nativeQuery = true
    )
	    PageAttrPropertiesEntity findByAttributeIdAndPropertyName(
	        @Param("attr_id") Integer attribute_id, 
	        @Param("property_name") String property_name
	    );}
