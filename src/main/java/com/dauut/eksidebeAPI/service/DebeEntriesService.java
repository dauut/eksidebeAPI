package com.dauut.eksidebeAPI.service;

import com.dauut.eksidebeAPI.model.Entry;
import com.dauut.eksidebeAPI.model.EntryAudit;

import java.time.LocalDate;
import java.util.List;

public interface DebeEntriesService {

    List<EntryAudit> retDebeEntriesOfDate(LocalDate date);

    Entry retEntryById(int id);

    int retEntryCountOfDate(LocalDate date);

}
