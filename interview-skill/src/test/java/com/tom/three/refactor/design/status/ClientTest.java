package com.tom.three.refactor.design.status;

import com.tom.three.refactor.design.status.VideoTweetState;
import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class ClientTest {

    @Test
    public void getTitle() {
        Client client = new Client();
        client.setTweetState(new VideoTweetState());
        System.out.printf("%s",client.getTitle());

    }
}