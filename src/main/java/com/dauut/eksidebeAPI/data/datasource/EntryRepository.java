package com.dauut.eksidebeAPI.data.datasource;

import com.dauut.eksidebeAPI.model.Entry;
import com.dauut.eksidebeAPI.model.EntryAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<EntryAudit, Integer> {
    List<EntryAudit> findByDate(LocalDate date);
    List<EntryAudit> findAllByEntryId(int id);
}
