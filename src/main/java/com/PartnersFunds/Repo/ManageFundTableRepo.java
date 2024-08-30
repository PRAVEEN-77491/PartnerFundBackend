package com.PartnersFunds.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PartnersFunds.Entities.ManageFundTablesEntity;

public interface ManageFundTableRepo extends JpaRepository<ManageFundTablesEntity, Integer> {

}
