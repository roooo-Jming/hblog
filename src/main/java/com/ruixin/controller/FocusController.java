package com.ruixin.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruixin.bean.*;
import com.ruixin.common.entity.Page;
import com.ruixin.common.utils.Views;
import com.ruixin.database.mapper.FocusMapper;
import com.ruixin.service.NewsService;
import com.ruixin.util.UserUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Mingrui Ji
 * @CreateTime 7/27/21 7:17 PM
 * @Version 1.0.0
 */

@Controller
@RequestMapping("/focus")
public class FocusController {

    public static String user_focus=null;

    @Resource
    private FocusMapper focusMapper;

    private Focus focus;
    private PlayNews news;

    @RequestMapping("/first")
    public String focusList(){

//        try {
//            news=focusMapper.focusList(username);
//            model.addAttribute("news",news);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        return Views.FOCUS_PAGE;
    }

    @RequestMapping("/list")
    public String showList() {
        return Views.FOCUS_LIST;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(@RequestParam("userName") String userName) {
        System.out.println(userName);
        user_focus=userName;
        return null;
    }

    @RequestMapping("/getInfo")
    @ResponseBody
    public String getInfo(@RequestParam("articleId")String articleId,@RequestParam("userName") String userName){

        int artId=Integer.parseInt(articleId);
        focus=new Focus(new Integer(artId),userName);

        HashMap<String,Object> hashMap=new HashMap<>();

        try {
            if(focusMapper.query(focus)!=null){
                return null;
            }else {
                focusMapper.addFocus(focus);
                hashMap.put("articleId",Integer.parseInt(articleId));
                hashMap.put("userName",userName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return new JSONObject(hashMap).toString();
    }



}
