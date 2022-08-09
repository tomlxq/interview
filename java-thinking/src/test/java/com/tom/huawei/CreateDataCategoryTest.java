package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateDataCategoryTest {
    CreateDataCategory cdc = null;

    @Before
    public void setUp() throws Exception {
        cdc = new CreateDataCategory();
    }

    @Test
    public void func() {
        assertEquals(5, cdc.func("5 2 1 2 3 4 5 6 7 8 9 10"));
    }
}