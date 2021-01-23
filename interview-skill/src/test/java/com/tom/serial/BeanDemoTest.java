package com.tom.serial;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/25
 */
@Slf4j
public class BeanDemoTest {
    @Test
    public void test() {
        String a = "{\"key\":\"123\", \"title\":\"asd\", \"values\":[\"a\", \"b\", \"c\", \"d\"], \"defaultValue\":\"a\"}";

        Gson Gson = new Gson();
        BeanDemo testBean = Gson.fromJson(a, new TypeToken<BeanDemo>() {
        }.getType());

        long now = System.currentTimeMillis();
        for (int i = 0; i < 1000; ++i) {
            Gson.fromJson(a, new TypeToken<BeanDemo>() {
            }.getType());
        }
        log.debug("time {}", "Gson parse use time=" + (System.currentTimeMillis() - now));

        now = System.currentTimeMillis();
        for (int i = 0; i < 1000; ++i) {
            BeanDemo.fromJsonString(a);
        }
        log.debug("time {}", "jsonobject parse use time=" + (System.currentTimeMillis() - now));

        now = System.currentTimeMillis();
        for (int i = 0; i < 1000; ++i) {
            Gson.toJson(testBean);
        }
        log.debug("time {}", "Gson tojson use time=" + (System.currentTimeMillis() - now));

        now = System.currentTimeMillis();
        for (int i = 0; i < 1000; ++i) {
            BeanDemo.toJsonString(testBean);
        }
        log.debug("time {}", "jsonobject tojson use time=" + (System.currentTimeMillis() - now));
    }
}