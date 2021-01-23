package com.example.array.demo;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

@Slf4j
public class DataArrayTest {


    @Test
    public void setUp() throws Exception {
        DataArray dataArray = new DataArray(100);
        dataArray.insert("Luo", "Tom", 18);
        dataArray.insert("Zhang", "Jhon", 18);
        dataArray.insert("Li", "Luce", 18);
        dataArray.insert("Wang", "Jack", 18);
        dataArray.insert("Ni", "Feifei", 18);
        dataArray.insert("Peng", "Hans", 18);
        dataArray.insert("Ke", "Lulu", 18);
        dataArray.insert("Hu", "Lili", 18);
        dataArray.display();
        log.info("delete Person {} {} {}", "Hu", "Peng", "Li");
        dataArray.delete("Hu");
        dataArray.delete("Peng");
        dataArray.delete("Li");
        dataArray.display();
        Optional<Person> wang = dataArray.find("Wang");
        log.info("find this person {}", wang.orElse(null));
    }
}
