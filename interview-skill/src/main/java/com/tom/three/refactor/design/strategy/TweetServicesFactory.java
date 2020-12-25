package com.tom.three.refactor.design.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class TweetServicesFactory {

    private static final Map<String, ITweetService> map = new HashMap<>();
    static {
        map.put("paperTweet", new PaperTweetServiceImpl());
        map.put("videoTweet", new VideoTweetServiceImpl());
    }
    public static ITweetService getTweetService(String type) {
        return map.get(type);
    }
}