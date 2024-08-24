package com.PartnersFunds.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PartnersFunds.Entities.ViewObjectsEntity;

@Repository
public interface ViewObjectsRepo extends JpaRepository<ViewObjectsEntity, Integer> {

    @Query(value = "SELECT view_object_sql_query FROM xxpf_view_objects WHERE view_object_name = :viewObjectName", nativeQuery = true)
    Object findQueryByViewObjectName(@Param("viewObjectName") String viewObjectName);

}
