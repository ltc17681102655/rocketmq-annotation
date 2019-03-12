package com.yang.springbootrocketmq.rocketmq;

import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;

import java.util.Map;

/**
 * @author: Yang
 * @date: 2018/12/23 23:57
 * @description:
 */
@MQConsumer(topic = "REFUND_TOPIC", consumerGroup = "AFTERSALE_GROUP_1", tag = "REFUND_TAG")
public class MyConsumer extends AbstractMQPushConsumer<Object> {
    @Override
    public boolean process(Object o, Map<String, Object> map) {
        System.out.println("=====================================");
        System.out.println(o);
        System.out.println("=====================================");
        return true;
    }
//    @Override
//    public boolean process(Map<String, Object> map, Map<String, Object> mapobj) {
////        map.put("adNO", "1234");
////        map.put("userId", "1314520");
//        System.out.println("=====================================");
//        System.out.println(map.get("adNO") + "==");
//        System.out.println(map.get("userId") + "==");
//        System.out.println("=====================================");
//        return false;
//    }

//    @Override
//    public boolean process(Object o, Map map) {
//        System.out.println("=====================================");
//        if (o instanceof Map) {
//            Map o1 = (Map) o;
//            System.out.println(o1.get("adNO") + "==");
//            System.out.println(o1.get("userId") + "==");
//        }
//
////        System.out.println(o.toString());
////        System.out.println(map.toString());
//        System.out.println("=====================================");
//        return false;
//    }


//    @Override
//    public boolean process(Map map, Map<String, Object> map2) {
//        System.out.println("=====================================");
//        System.out.println(map.get("adNO") + "==");
//        System.out.println(map.get("userId") + "==");
//        return true;
//    }


}
