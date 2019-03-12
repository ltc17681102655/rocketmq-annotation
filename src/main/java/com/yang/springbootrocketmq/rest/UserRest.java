package com.yang.springbootrocketmq.rest;

import com.maihaoche.starter.mq.base.MessageBuilder;
import com.yang.springbootrocketmq.rocketmq.MyProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yang
 * @date: 2018/12/23 23:59
 * @description: http://localhost:8080/user/send
 */
@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private MyProducer myProducer;

    //    https://blog.csdn.net/wd2014610/article/details/81781109
    @GetMapping("/send")
    public String send() {
        Map<String, Object> map = new HashMap<>();
        map.put("adNO", "1234");
        map.put("userId", "1314520");

//        String json = "{\n" +
////                " \"abnormal\": 0,\n" +
////                " \"agentFee\": \"4400\",\n" +
////                " \"asType\": 4,\n" +
////                " \"freightCompensation\": \"4400\",\n" +
////                " \"goodPayment\": \"4400\",\n" +
////                " \"onlyCompensateFee\": \"0\",\n" +
////                " \"responsibleParty\": 10,\n" +
////                " \"status\": 7,\n" +
////                " \"step\": 0,\n" +
////                " \"threeOrderId\": \"218eb47c5b4847ac83e8547e827ea1e4\",\n" +
////                " \"userId\": \"78ee02b2dff83db0f4e53a10e6de367e\"\n" +
////                "}";

//        String userId = jsonObject.getString("userId");
//        String threeOrderId = jsonObject.getString("threeOrderId");
//        Integer afterSaleStatus = jsonObject.getInteger("status");

//        AAA AAA = new AAA().setAbnormal(0).setAgentFee("4400").setAsType(4).setFreightCompensation("4400")
////                .setGoodPayment("4400").setOnlyCompensateFee("0").setResponsibleParty(10).setStatus(7).setStep(0).setThreeOrderId("218eb47c5b4847ac83e8547e827ea1e4")
////                .setUserId("78ee02b2dff83db0f4e53a10e6de367e");

        Message msg = MessageBuilder.of(new AAA().setUserId("78ee02b2dff83db0f4e53a10e6de367e").setStatus(7).setThreeOrderId("218eb47c5b4847ac83e8547e827ea1e4"))
                .topic("AFTERSALE_REFUND_TOPIC")
                .tag("REFUND_TAG")
                .build();
        this.myProducer.syncSend(msg);
        return "SUCCESS";
    }
//    topic = "AFTERSALE_REFUND_TOPIC", consumerGroup = "AKUCUN_ORDER_GROUP", tag = "REFUND_TAG"
}
