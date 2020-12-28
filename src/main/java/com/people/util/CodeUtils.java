/**
 * 生成随机验证码
 */
package com.people.util;


import java.util.Random;

public class CodeUtils {

    public static String randomCode(int size,String type){
        String numTemp = "0123456789";
        String charTemp = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        //创建字符串变量
        StringBuilder codeStr = new StringBuilder();
        if("numCode".equals(type)){
            for(int i=0;i<size;i++){
                char s = numTemp.charAt(new Random().nextInt(numTemp.length()));
                codeStr.append(s);
            }
        }else if("charCode".equals(type)){
            for(int i=0;i<size;i++){
                char s = charTemp.charAt(new Random().nextInt(charTemp.length()));
                codeStr.append(s);
            }
        }
        return codeStr.toString();
    }
}
