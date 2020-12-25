package com.tom.three.refactor.enummethod;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class TweetStrategyDemo {
    public void getTitle() {
        TweetStrategyEnum tweetStrategyEnum = TweetStrategyEnum.valueOf(1);
        if(tweetStrategyEnum != null){
            System.out.println(tweetStrategyEnum.getTitle());
        }
    }
    public static void main(String[] args) {
        TweetStrategyDemo c=new TweetStrategyDemo();
        c.getTitle();
    }
}
