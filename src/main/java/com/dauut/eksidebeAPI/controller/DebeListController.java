package com.dauut.eksidebeAPI.controller;

import com.dauut.eksidebeAPI.model.Entry;
import com.dauut.eksidebeAPI.service.DebeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("debe")
public class DebeListController {

    private final DebeListService debeListService;

    public DebeListController(DebeListService debeListService) {
        this.debeListService = debeListService;
    }

    @RequestMapping("{date}")
    public List<Entry> getDebeListOfDate(@PathVariable String date) {

        List<Entry> entries = debeListService.getAllEntriesForThisDay(date);

        return entries.stream().map(entry -> new Entry(entry.getEntryId(),entry.getUrl(),
                entry.getHeader(), entry.getDate(),entry.getAuthor())).
                collect(Collectors.toList());
//        return entries;
    }


}
