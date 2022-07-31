package com.example;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

@Slf4j
public class DataArrayTest {
    DataArrayDemo dataArrayDemo;

    @Before
    public void setUp() throws Exception {
        dataArrayDemo = new DataArrayDemo(100);
        dataArrayDemo.insert("Luo", "Tom", RandomUtils.nextInt(0, 100));
        dataArrayDemo.insert("Zhang", "Jhon", RandomUtils.nextInt(0, 100));
        dataArrayDemo.insert("Li", "Luce", RandomUtils.nextInt(0, 100));
        dataArrayDemo.insert("Wang", "Jack", RandomUtils.nextInt(0, 100));
        dataArrayDemo.insert("Ni", "Feifei", RandomUtils.nextInt(0, 100));
        dataArrayDemo.insert("Peng", "Hans", RandomUtils.nextInt(0, 100));
        dataArrayDemo.insert("Ke", "Lulu", RandomUtils.nextInt(0, 100));
        dataArrayDemo.insert("Hu", "Lili", RandomUtils.nextInt(0, 100));
        log.info("init array data");
        dataArrayDemo.display();
    }

    @After
    public void tearDown() throws Exception {
        log.info("tear down array data");
        dataArrayDemo.display();
    }

    @Test
    public void deleteAndFind() throws Exception {
        log.info("delete Person {} {} {}", "Hu", "Peng", "Li");
        dataArrayDemo.delete("Hu");
        dataArrayDemo.delete("Peng");
        dataArrayDemo.delete("Li");
        dataArrayDemo.display();
        Optional<Person> wang = dataArrayDemo.find("Wang");
        log.info("find this person {}", wang.orElse(null));
    }

    @Test
    public void orderInsertByLastName() throws Exception {
        dataArrayDemo.orderInsertByLastName();
    }

    @Test
    public void orderInsertByAge() throws Exception {
        dataArrayDemo.orderInsertByAge();
    }
}
