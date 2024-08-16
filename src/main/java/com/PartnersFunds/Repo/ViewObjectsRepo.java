package com.PartnersFunds.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PartnersFunds.Entities.ViewObjectsEntity;

@Repository
public interface ViewObjectsRepo extends JpaRepository<ViewObjectsEntity, Integer> {

}
