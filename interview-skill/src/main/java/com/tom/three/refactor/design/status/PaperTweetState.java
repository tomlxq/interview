package com.tom.three.refactor.design.status;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class PaperTweetState implements TweetState{
    @Override
    public String getTitle() {
        return "长贴标题";
    }
}
