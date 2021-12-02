package com.ruixin.util;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author Mingrui Ji
 * @CreateTime 7/26/21 12:37 PM
 * @Version 1.0.0
 */

public class SpeechClient {

    private static volatile SpeechClient speechClient;
    public static String spd;
    public static String vol;
    public static String per;

    private AipSpeech client = null;

    private SpeechClient(String APP_ID, String API_KEY, String SECRET_KEY) {
        client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
    }

    public static SpeechClient getInstance(String APP_ID, String API_KEY, String SECRET_KEY) {
        if (speechClient == null) {
            synchronized (SpeechClient.class) {
                if (speechClient == null) {
                    speechClient = new SpeechClient(APP_ID, API_KEY, SECRET_KEY);
                }
            }
        }
        return speechClient;
    }

    public String generateMp3(String text, String path) { //text是文本内容 path是保存的文件路径
        String name = null;
        String fileName=null;
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd",spd);
        options.put("vol",vol);
        options.put("per",per);

        TtsResponse res = client.synthesis(text, "zh", 1, options); //合成语音

        byte[] data = res.getData();//得到的是生成的语音的二进制数据
        //定义变量调用转换格式
        if (data != null) {
            try {
                //生成随机的文件名,规避文件名冲突的问题
                name = UUID.randomUUID().toString() + ".mp3";
                fileName = path + "/" + name;
                Util.writeBytesToFileSystem(data, fileName);//将语音数据保存成mp3文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
