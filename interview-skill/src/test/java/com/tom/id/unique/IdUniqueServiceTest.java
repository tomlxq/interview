package com.tom.id.unique;

import com.tom.id.Config;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
@Slf4j
public class IdUniqueServiceTest {
    @Autowired
    @Qualifier("uuidService")
    IdUniqueService idUniqueService;
    @Autowired
    @Qualifier("redisService")
    IdUniqueService idUniqueService1;

    @Test
    public void generateId() throws InterruptedException {
        Runnable runnable = () -> {
            log.info("insert into t1_id(id) values('" + idUniqueService.generateId() + "');");
        };
        T1Util.timeTasks(100, 100, runnable);
    }

    @Test
    public void generateId2() throws InterruptedException {
        Runnable runnable = () -> {
            log.info("insert into t1_id(id) values('" + idUniqueService1.generateId() + "');");
        };
        T1Util.timeTasks(100, 100, runnable);

    }
}