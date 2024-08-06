package com.PartnersFunds.Repo;

import com.PartnersFunds.Entities.ExpressionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpressionRepo extends JpaRepository<ExpressionEntity, Long> {
}
