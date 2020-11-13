package com.dauut.eksidebeAPI.data.datasource;

import com.dauut.eksidebeAPI.model.EntryAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<EntryAudit, Integer> {

}
