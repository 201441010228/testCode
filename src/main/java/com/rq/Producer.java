package com.rq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import java.util.Date;

/**
 * @Auther: 张扬
 * @Date: 2018/11/28 15:17
 * @Description:
 */
public class Producer {
     public static  void main(String[] args) throws MQClientException {
         DefaultMQProducer defaultMQProducer = new DefaultMQProducer("rq-test");
         defaultMQProducer.setNamesrvAddr("127.0.0.1:9876");
         defaultMQProducer.setInstanceName("producer");
         defaultMQProducer.start();
         try{
             int count = 1;
             while(count<100){
                 Thread.sleep(1000);
                 Message msg = new Message("topic-test","tag-test",(new Date() + "Hello RQ "+count).getBytes());
                SendResult sendResult =  defaultMQProducer.send(msg);
             }
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             defaultMQProducer.shutdown();
         }
     }
}
