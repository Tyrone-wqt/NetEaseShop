package com.wqt.controller;


import com.wqt.pojo.Content;
import com.wqt.pojo.User;
import com.wqt.service.ContentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by lenovo on 2018/3/7.
 */
@Controller
public class ContentController {
    @Resource
    private ContentService contentService;

    @RequestMapping("/")
    public String getIndex(HttpSession session, Model model, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        List<Content> contentList = null;
        int type = 0;
        if (request.getParameter("type") != null) type = Integer.valueOf(request.getParameter("type"));
        if (user != null) {
            //为买家
            if (user.getUserType() == 0) {
                if (type == 1) {
                    //得到未购买内容列表
                    contentList = contentService.getUnpurchasedContentListById(user.getId());
                } else {
                    contentList = contentService.getBuyerContentListById(user.getId());
                }
            } else {
                //得到卖家的内容列表
                contentList = contentService.getSellerContentListById(user.getId());
            }

        } else {
            //未登录状态，得到所有内容列表
            contentList = contentService.getAllContentList();
        }
        model.addAttribute("contentList", contentList);
        model.addAttribute("user", user);
        return "index";
    }


    @RequestMapping("/show")
    public String showContent(@RequestParam int id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        if (user == null || user.getUserType() == 1)
            model.addAttribute("content", contentService.getContentById(id));
        else
            model.addAttribute("content", contentService.getContentByBuyerIdAndContentId(user.getId(), id));
        return "show";
    }

    @RequestMapping("/deleteContent")
    @ResponseBody
    public Map<String, Object> deleteContent(int contentId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", user);
        //是卖家
        if (user != null && user.getUserType() == 1) {
            int rows = contentService.deleteContentByContentId(contentId);
            if (rows > 0) {
                map.put("code", 200);
                map.put("result", true);
            } else {
                map.put("code", 201);
                map.put("result", false);
            }

        } else {
            map.put("code", 201);
            map.put("result", false);
        }
        return map;
    }

    @RequestMapping("/edit")
    public String editContent(@RequestParam int id, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "login";
        model.addAttribute("user", user);
        Content content = contentService.getContentById(id);
        model.addAttribute("content", content);
        return "edit";
    }


}
