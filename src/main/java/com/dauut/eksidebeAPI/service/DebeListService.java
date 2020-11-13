package com.dauut.eksidebeAPI.service;

import com.dauut.eksidebeAPI.data.datasource.EntryRepository;
import com.dauut.eksidebeAPI.model.Entry;
import com.dauut.eksidebeAPI.model.EntryAudit;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DebeListService{

    private final EntryRepository entryRepository;

    public DebeListService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }


    public List<Entry> getAllEntriesForThisDay(LocalDate date){

        List<EntryAudit> entryAudits = entryRepository.findAll();
        List<Entry> entries = new ArrayList<>();

        for (EntryAudit e : entryAudits){
            Entry entry = new Entry(e.getEntryId(),e.getUrl(),e.getHeader(),date.toString(),"Generic Author");
            entries.add(entry);
        }

        return entries;
    }
}
