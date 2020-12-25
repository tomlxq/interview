package com.tom.three.refactor.enummethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
@AllArgsConstructor
public enum TweetStrategyEnum {
    PAPER(1) {
        @Override
        String getTitle() {
            return "长贴标题";
        }
    },
    VIDEO_TWEET(2) {
        @Override
        String getTitle() {
            return "视频贴标题";
        }
    },
    DEFAULT_TWEET(3) {
        @Override
        String getTitle() {
            return "短贴标题";
        }
    };
    private final int type;
    abstract String getTitle();
    public static TweetStrategyEnum valueOf(int type) {
        for (TweetStrategyEnum tweetStrategyEnum : TweetStrategyEnum.values()) {
            if (tweetStrategyEnum.type == type) {
                return tweetStrategyEnum;
            }
        }
        return null;
    }
}
