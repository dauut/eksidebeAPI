package com.dauut.eksidebeAPI.data.datasource;

import com.dauut.eksidebeAPI.model.DebeAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface DebeRepository extends JpaRepository<DebeAudit, LocalDate> {
}
