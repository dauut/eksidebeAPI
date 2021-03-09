package com.dauut.eksidebeAPI.service;

import com.dauut.eksidebeAPI.data.datasource.DebeRepository;
import com.dauut.eksidebeAPI.data.datasource.EntryRepository;
import com.dauut.eksidebeAPI.model.DebeAudit;
import com.dauut.eksidebeAPI.model.Entry;
import com.dauut.eksidebeAPI.model.EntryAudit;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class DebeEntriesServiceImp implements DebeEntriesService {

    private final EntryRepository entryRepository;
    private final DebeRepository debeRepository;

    public DebeEntriesServiceImp(EntryRepository entryRepository, DebeRepository debeRepository) {
        this.entryRepository = entryRepository;
        this.debeRepository = debeRepository;
    }

    @Override
    public List<EntryAudit> retDebeEntriesOfDate(LocalDate date) {
        return entryRepository.findByDate(date);
    }

    @Override
    public Entry retEntryById(int id) {
        List<EntryAudit> ea = entryRepository.findAllByEntryId(id);
        if (ea == null || ea.isEmpty()) return null;
        return entryAuditToEntry(ea.get(0));
    }

    @Override
    public int retEntryCountOfDate(LocalDate date) {
        DebeAudit debeAudit = debeRepository.findDebeAuditByListDate(date);
        return debeAudit.getEntryCount();
    }

    private Entry entryAuditToEntry(EntryAudit entryAudit) {
        return new Entry(entryAudit.getEntryId(), entryAudit.getUrl(), entryAudit.getHeader(), entryAudit.getDate());
    }
}
