package com.dauut.eksidebeAPI.service;

import com.dauut.eksidebeAPI.data.datasource.EntryRepository;
import com.dauut.eksidebeAPI.model.Entry;
import com.dauut.eksidebeAPI.model.EntryAudit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DebeListService {

    private final EntryRepository entryRepository;
    //LOCAL SESSION CACHE MECHANISM - No need to visit to db for older request bc they won't change
    private static final Map<String, List<Entry>> requestedDebeLists = new HashMap<>();

    public DebeListService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }


    public List<Entry> getAllEntriesForThisDay(String date) {

        if (requestedDebeLists.containsKey(date)){
            System.out.println("RETURNED FROM CACHE");
            return requestedDebeLists.get(date);
        }

        List<EntryAudit> entryAudits = entryRepository.findAll();
        List<Entry> entries = new ArrayList<>();

        for (EntryAudit e : entryAudits){
            if (e.getDate().equals(date)){
                Entry entry = new Entry(e.getEntryId(),e.getUrl(),e.getHeader(), e.getDate(),"Generic Author");
                entries.add(entry);
            }
        }

        requestedDebeLists.put(date, entries);
        return entries;
    }
}
