package com.alpha.springboot.controller;

import com.alpha.springboot.bean.MyUrl;
import com.alpha.springboot.mapper.UrlMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.nio.cs.ext.MacThai;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
public class SUrlController {

    @Resource
    UrlMapper urlMapper;
//服务器地址，默认80端口
    String shorturl = "localhost/";

//生成短网址并返回给用户 resful规范
    @ResponseBody
    @GetMapping("/myurl")
    public String save(MyUrl myUrl, Model model){
        String rendom = getRendom(4);
        myUrl.setSrandom(rendom);
        int i = urlMapper.insUrl(myUrl);
        if(i > 0){
         //插入成功
            shorturl += rendom;
            System.out.println("myurl:"+ myUrl);
            model.addAttribute("result",shorturl);
            return shorturl;
        }else {
            return "error";
        }

    }

    //接受短网址并跳到指定页面
    @GetMapping("/{rendom}")
    public String  topage(@PathVariable("rendom") String shorturl){
        MyUrl myUrl = urlMapper.selBySUrl(shorturl);
        if(myUrl != null){
            //重定向到源地址页面
            String longurl = myUrl.getLongurl();
            return "redirect:"+longurl;
        }else {
            return "error";
        }
    }

    /**
     * 生成随机数
     * @return
     */
    public String getRendom(int length){
        String var = "";
        Random random = new Random();

        for (int i = 0; i < length; i++){
            //输出字母还是数字
            String CharOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if(CharOrNum.equals("char")){
                //大写还是小写
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                //asall表 数字转字母
                var += (char)(random.nextInt(26)+temp);
            }else if(CharOrNum.equals("num")){
                var += random.nextInt(10);
            }
        }
    return var;
    }
}
