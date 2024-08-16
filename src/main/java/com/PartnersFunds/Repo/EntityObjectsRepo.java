package com.PartnersFunds.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.PartnersFunds.Entities.EntityObjectsEntity;

public interface EntityObjectsRepo extends JpaRepository<EntityObjectsEntity, Integer> {

	
	@Query(value="SELECT entity_table_name FROM xxpf_entity_objects p WHERE p.entity_object_name = :entity_object_name",nativeQuery=true)
	String findByObjectName(@Param("entity_object_name") String entity_object_name);

//	@Query(value="SELECT * FROM XXPF_PAGE_CONFIGS_ATTR p WHERE p.attr_type = :type",nativeQuery=true)
//	List<AttrEntity> findByAttrType(@Param("type") String type);
//	
}
