package com.PartnersFunds.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PartnersFunds.DTO.ManageFundDTO;
import com.PartnersFunds.Entities.ManageFundEntity;

public interface ManageFundRepo extends JpaRepository<ManageFundEntity, Integer> {

//	ManageFundDTO save(ManageFundDTO manageFunds);

}
