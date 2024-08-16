package com.PartnersFunds.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PartnersFunds.Entities.LookupsEntity;

public interface LookupsRepo extends JpaRepository<LookupsEntity, Integer> {

}
