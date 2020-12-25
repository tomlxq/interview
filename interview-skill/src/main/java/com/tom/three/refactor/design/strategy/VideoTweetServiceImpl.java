package com.tom.three.refactor.design.strategy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class VideoTweetServiceImpl implements ITweetService{
    @Override
    public String getTitle() {
        return "视频贴标题";
    }
}
