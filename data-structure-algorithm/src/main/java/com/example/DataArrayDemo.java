package com.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

@Slf4j
public class DataArrayDemo {
    private Person[] data = null;
    private int nElement;

    public DataArrayDemo(int max
    ) {
        data = new Person[max];
        nElement = 0;
    }

    public void insert(String lastName, String firstName, int age) {
        data[nElement] = new Person(lastName, firstName, age);
        nElement++;
    }

    public Optional<Person> find(String lastName) {
        Optional<Person> first = Arrays.stream(data).filter(v -> v.getLastName().equals(lastName)).findFirst();
        return first;

    }

    public boolean delete(String lastName) {
        int i;
        for (i = 0; i < nElement; i++) {
            if (data[i].getLastName().equals(lastName)) {
                break;
            }
            if (nElement == i) {
                return false;
            }
        }
        for (int k = i; k < nElement; k++) {
            data[k] = data[k + 1];
        }
        nElement--;
        return true;
    }

    public void display() {
        IntStream.range(0, nElement).forEach(i -> log.info("{}", data[i]));
    }

    public void orderInsertByLastName() {
        int out, in;
        for (out = 1; out < nElement; out++) {
            Person tmp = data[out];
            in = out;
            while (in > 0 && data[in - 1].getLastName().compareTo(tmp.getLastName()) > 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = tmp;
        }
    }

    public void orderInsertByAge() {
        int out, in;
        for (out = 1; out < nElement; out++) {
            Person tmp = data[out];
            in = out;
            while (in > 0 && data[in - 1].getAge() > tmp.getAge()) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = tmp;
        }
    }
}
