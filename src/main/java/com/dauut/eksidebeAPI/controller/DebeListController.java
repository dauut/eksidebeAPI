package com.dauut.eksidebeAPI.controller;

import com.dauut.eksidebeAPI.model.Entry;
import com.dauut.eksidebeAPI.model.EntryAudit;
import com.dauut.eksidebeAPI.service.DebeEntriesService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("debe")
public class DebeListController {

    private final DebeEntriesService debeEntriesService;

    public DebeListController(DebeEntriesService debeEntriesService) {
        this.debeEntriesService = debeEntriesService;
    }

    @RequestMapping("{date}")
    public List<Entry> getDebeListOfDate(@PathVariable String date) {
        //ToDo validate string
//        System.out.println("DEBE REQUESTED");
        try {
            LocalDate localDate = LocalDate.parse(date);
            List<EntryAudit> debeList = debeEntriesService.retDebeEntriesOfDate(localDate);
            return debeList.stream()
                    .map(entry -> new Entry(entry.getEntryId(), entry.getUrl(), entry.getHeader(), entry.getDate()))
                    .collect(Collectors.toList());
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Entry getEntryById(@RequestParam(value = "id") Integer id) {
        return debeEntriesService.retEntryById(id);
    }

}
