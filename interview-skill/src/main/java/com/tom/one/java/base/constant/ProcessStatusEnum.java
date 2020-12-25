package com.tom.one.java.base.constant;

/**
 * 【参考】枚举类名带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。
 * 说明：枚举其实就是特殊的常量类，且构造方法被默认强制是私有。
 * 正例：枚举名字为 ProcessStatusEnum 的成员名称：SUCCESS / UNKNOWN_REASON。
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public enum ProcessStatusEnum {
    SUCCESS,  UNKNOWN_REASON;

}
