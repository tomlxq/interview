package com.tom.three.refactor.design.strategy;

import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class TweetServicesFactoryTest {

    @Test
    public void getTweetService() {
        ITweetService tweetService = TweetServicesFactory.getTweetService("paperTweet");
        System.out.printf("%s", tweetService.getTitle());
    }
}