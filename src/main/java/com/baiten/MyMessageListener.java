package com.baiten;

import com.google.gson.Gson;
import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * Created by windy on 2018/3/26.
 */
public class MyMessageListener implements MessageListener {

    Gson gson = new Gson();

    public void onMessage(Message message) {

        if (message instanceof TextMessage) {
            try {
                TextMessage txtMsg = (TextMessage) message;
                String msg = txtMsg.getText();
                //实际项目中拿到String类型的message(通常是JSON字符串)之后，
                //会进行反序列化成对象，做进一步的处理
                int i = 7/0;
                System.out.println("consumer1 receive txt msg===" + msg);
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }
}
