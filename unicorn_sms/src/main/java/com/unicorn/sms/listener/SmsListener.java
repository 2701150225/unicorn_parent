package com.unicorn.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.unicorn.sms.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wangsusheng
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {
    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;

    @RabbitHandler
    public void executeSms(Map<String, String> map){
        String mobile = map.get("mobile");
        String code = map.get("code");
        System.out.println("手机号："+map.get("mobile"));
        System.out.println("验证码："+map.get("code"));
        try {
            smsUtil.sendSms(mobile, template_code, sign_name, "{\"code\":\""+code+"\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
