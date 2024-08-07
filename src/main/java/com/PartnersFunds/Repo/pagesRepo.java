package com.PartnersFunds.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PartnersFunds.Entities.pagesEntity;

@Repository
public interface pagesRepo extends JpaRepository<pagesEntity, Integer>{
	
	@Query(value="select * from xxpf_pages xp where xp.page_id = :page_id" , nativeQuery = true)
	pagesEntity findByPage_id(@Param("page_id") int page_id);

	@Query(value = "SELECT p.* FROM xxpf_pages p JOIN xxpf_page_attributes a ON p.page_id = a.page_id WHERE p.page_id = :page_id AND a.attribute_id IN :attribute_ids", nativeQuery = true)
	pagesEntity findByPageIdAndAttributeIds(@Param("page_id") int page_id, @Param("attribute_ids") List<Integer> attribute_ids);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 'true' ELSE 'false' END FROM xxpf_pages xp WHERE xp.page_name = :page_name", nativeQuery = true)
	boolean findbyPageName(@Param("page_name") String pageName);

}
