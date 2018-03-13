package com.wqt.controller;

import com.wqt.pojo.Content;
import com.wqt.pojo.User;
import com.wqt.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by lenovo on 2018/3/12.
 */
@Controller
public class PublishController {
    public static final String SEPARTOR=java.io.File.separator;
    @Resource
    private ContentService contentService;

    @RequestMapping("/publish")
    public String publishContent(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "login";
        return "publish";
    }

    @RequestMapping("/publishSubmit")
    public String publishSubmit(Content content, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "login";
        content.setSid(user.getId());
        contentService.publishNewContent(content);
        model.addAttribute("user", user);
        if (content.getId() != 0)
            model.addAttribute("content", content);
        return "publishSubmit";
    }

    @RequestMapping("/editSubmit")
    public String editSubmit(Content content,HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        if (user == null) return "login";
        model.addAttribute("user",user);
        if(content==null) return "editSubmit";
        content.setSid(user.getId());
        int rows=contentService.updateContent(content);
        if(rows!=0)
            model.addAttribute("content",content);
        return "editSubmit";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> upload(@RequestParam(value = "file", required = false)MultipartFile multipartFile,HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        if(multipartFile==null||multipartFile.getSize()==0){
            map.put("status",201);
            map.put("message","File is empty");
        }
        String filedir = request.getServletContext().getRealPath("/")+"img"+SEPARTOR;
        String fileName=multipartFile.getOriginalFilename();
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        String newfileName=UUID.randomUUID().toString()+suffix;
        try {
            File file=new File(filedir+newfileName);
            multipartFile.transferTo(file);
        }catch (IOException e) {
            e.printStackTrace();
            map.put("status",201);
            map.put("message","An error occurred!");
        }
        map.put("status",200);
        map.put("result",request.getContextPath()+"img/"+newfileName);
        return map;
    }
}
