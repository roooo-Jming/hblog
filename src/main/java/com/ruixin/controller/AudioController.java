package com.ruixin.controller;

import com.ruixin.common.utils.Views;
import com.ruixin.util.SpeechClient;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

/**
 * @Author Mingrui Ji
 * @CreateTime 7/27/21 9:05 AM
 * @Version 1.0.0
 */

@Controller
public class AudioController {

    @PostMapping("/audioSetting")
    public String audioSetting(@Param("spd")String spd,@Param("vol") String vol,@Param("sex") String sex){

        if ("慢".equals(spd)){
            spd="1";
        }else if ("适中".equals(spd)){
            spd="5";
        }else {
            spd="9";
        }

        if ("大".equals(vol)){
            vol="1";
        }else if ("适中".equals(vol)){
            vol="5";
        }else {
            vol="9";
        }

        if ("男".equals(sex)){
            sex="1";
        }else {
            sex="0";
        }

        SpeechClient.spd=spd;
        SpeechClient.vol=vol;
        SpeechClient.per=sex;

        return Views.AUDIOSUCCESS;
    }
}
