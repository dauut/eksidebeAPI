package com.dauut.eksidebeAPI.service;

import com.dauut.eksidebeAPI.model.Debe;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DebeListServiceTest {

    LocalDate date = LocalDate.parse("2020-08-08");;

    @Test
    void getAllEntriesForThisDay() {
        System.out.println();
    }
}