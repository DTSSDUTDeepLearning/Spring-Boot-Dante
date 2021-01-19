package com.example.demo.config;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

public class Base64ToPic {
    public static boolean GenerateImage(String imgStr,String imageName) {
        //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) {
            //图像数据为空
            return false;
        }
        try {
            //Base64解码
            byte[] b = Base64.decodeBase64(new String(imgStr).getBytes());
            for(int i=0;i<b.length;++i) {
                if(b[i]<0) {
                    //调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            String imgFilePath = "E:/SpringBoot/firstDemo/demo/src/main/resources/static"+imageName; //新生成的图片的路径
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    // 从字符串中读取图片后缀名和base64字节数组字符串
    public static String[] split(String base64Str) {
        String[] s = base64Str.split(";base64,");
        if (s.length != 2) {
            return null;
        }
        String type = s[0].substring(s[0].lastIndexOf("/")+1); // 获取图片后缀名
        System.out.println(type);
        String base = s[1]; // 获取base64字符串
        String[] result = {type, base};
        return result;
    }
}
