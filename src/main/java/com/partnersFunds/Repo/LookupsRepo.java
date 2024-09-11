package com.partnersFunds.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.partnersFunds.Entities.LookupsEntity;

public interface LookupsRepo extends JpaRepository<LookupsEntity, Integer> {

}
