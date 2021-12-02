package com.ruixin.controller;

import com.alibaba.fastjson.JSON;
import com.ruixin.database.data.DisplayFocus;
import com.ruixin.database.mapper.FocusMapper;
import com.ruixin.database.data.DisplayFocus;
import com.ruixin.database.mapper.FocusMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Chenzhao Huang
 * @CreateTime 2021-07-29 1:25
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/display")
public class DisplayFocusController {
    @Resource
    private FocusMapper iFocusMapper;

    @RequestMapping("/search")
    @ResponseBody
    public String findFocus(){
        List<DisplayFocus> displayFocusList=iFocusMapper.queryAll(FocusController.user_focus);
        String jsonString = JSON.toJSONString(displayFocusList);
        String focuss="{\"code\":\"0\",\"msg\":\"ok\",\"count\":100,\"data\":"+jsonString+"}";
        System.out.println("-----"+focuss);
        return focuss;
    }
}
