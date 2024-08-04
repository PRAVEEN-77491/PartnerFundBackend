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

}
