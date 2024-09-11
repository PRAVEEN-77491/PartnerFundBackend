package com.partnersFunds.Repo;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.partnersFunds.Entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findByciscoCecId(String ciscoCecId);

}
