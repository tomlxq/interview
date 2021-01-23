package com.example;


import org.junit.Test;

public class OrdArrayTest {
    @Test
    public void oryArray() {
        OrdArray ordArray = new OrdArray(100);
        ordArray.insert(54);
        ordArray.insert(18);
        ordArray.insert(27);
        ordArray.insert(34);
        ordArray.insert(99);
        ordArray.insert(88);
        ordArray.insert(66);
        ordArray.insert(50);
        ordArray.display();
        int searchKey = 88;
        int i = ordArray.find(searchKey);
        if (i == ordArray.size()) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }
        ordArray.delete(18);
        ordArray.delete(88);
        ordArray.delete(34);
        ordArray.display();
    }
}
