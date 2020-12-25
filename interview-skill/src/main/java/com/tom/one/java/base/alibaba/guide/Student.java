package com.tom.one.java.base.alibaba.guide;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/5
 */
@Data
public class Student {
    private int id;

    public Student(int i) {
        id=i;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
