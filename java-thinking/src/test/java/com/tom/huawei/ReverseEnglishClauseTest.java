package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseEnglishClauseTest {
    ReverseEnglishClause rec = null;

    @Before
    public void setUp() throws Exception {
        rec = new ReverseEnglishClause();
    }

    @Test
    public void fun() {
        assertEquals("I a am developer.", rec.func("I am a developer.", 1, 2));
        assertEquals("world! Hello", rec.func("Hello world!", 0, 1));
        assertEquals("developer. a am I", rec.func("I am a developer.", 0, 3));
        assertEquals("EMPTY", rec.func("Hello!", 0, 3));
    }
}