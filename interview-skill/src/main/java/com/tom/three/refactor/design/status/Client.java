package com.tom.three.refactor.design.status;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class Client {

    private TweetState tweetState;

    public TweetState getTweetState() {
        return tweetState;
    }

    public void setTweetState(TweetState tweetState) {
        this.tweetState = tweetState;
    }

    public String getTitle() {
      return  tweetState.getTitle();
    }
}
