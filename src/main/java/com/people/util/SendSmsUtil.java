package com.people.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;

@Component
public class SendSmsUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean SendSms(String phone, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "", "IsynR3xS2vNVOJnz4OYBE1WGtAV1GH");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        // 默认接口
        request.setDomain("dysmsapi.aliyuncs.com");
        // 版本
        request.setVersion("2017-05-25");
        // 执行动作
        request.setAction("SendSms");
        // 发送请求的几个参数，可以参考官方文档
        request.putQueryParameter("RegionId", "cn-hangzhou");// 语言
        request.putQueryParameter("SignName", "母婴商城"); // 签名
        request.putQueryParameter("PhoneNumbers", phone);// 请求手机
        request.putQueryParameter("TemplateCode", "SMS_204455896");// 验证码模板，填写指定的模板代码
        request.putQueryParameter("TemplateParam", "{\"code\":" + code + "}");// 验证码参数
        //将验证码存入session域中
        stringRedisTemplate.opsForValue().set("phoneCode",code);
//        session.setAttribute("phoneCode", code);
        try {
            CommonResponse response = client.getCommonResponse(request);// 发送请求
            String resultData = response.getData();// 得到响应结果
            System.out.println(resultData);
            // 解析json结果
            String rsCode = new JsonParser().parse(resultData).getAsJsonObject().get("Code").getAsString();
            System.out.println(rsCode);
            if (rsCode.equals("OK")) {
                return true;
            }
            // 如果没有进入if则默认返回true
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

}
