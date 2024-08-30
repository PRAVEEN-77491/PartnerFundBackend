package com.PartnersFunds.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PartnersFunds.Entities.PlansEntity;

public interface PlansRepo extends JpaRepository<PlansEntity, Integer> {

}
