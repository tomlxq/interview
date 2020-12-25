package com.tom.one.java.base.service;

/**
 * 接口和实现类的命名有两套规则：
 * 1）【强制】对于 Service 和 DAO 类，基于 SOA 的理念，暴露出来的服务一定是接口，内部的实现类用
 * Impl 的后缀与接口区别。
 * 正例：CacheServiceImpl 实现 CacheService 接口。
 * 2）【推荐】如果是形容能力的接口名称，取对应的形容词为接口名（通常是–able 的形容词）。
 * 正例：AbstractTranslator 实现 Translatable 接口。
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public interface CacheService {
}
