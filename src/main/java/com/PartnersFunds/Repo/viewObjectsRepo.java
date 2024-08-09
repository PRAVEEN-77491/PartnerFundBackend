package com.PartnersFunds.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PartnersFunds.Entities.viewObjectsEntity;

@Repository
public interface viewObjectsRepo extends JpaRepository<viewObjectsEntity, Integer> {

}
