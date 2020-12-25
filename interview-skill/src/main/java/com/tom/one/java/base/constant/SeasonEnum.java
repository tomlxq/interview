package com.tom.one.java.base.constant;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public enum SeasonEnum {
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
    private int seq;
    SeasonEnum(int seq) {
        this.seq = seq;
    }
    public int getSeq() {
        return seq;
    }
}
