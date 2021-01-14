package com.dauut.eksidebeAPI.data.datasource;

import com.dauut.eksidebeAPI.model.DebeAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DebeRepository extends JpaRepository<DebeAudit, LocalDate> {
}
