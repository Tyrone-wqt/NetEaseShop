package com.wqt.service;

import com.wqt.pojo.Content;

import java.util.List;

/**
 * Created by lenovo on 2018/3/7.
 */
public interface ContentService {
    public List<Content> getAllContentList();

    public List<Content> getSellerContentListById(int userId);

    public List<Content> getBuyerContentListById(int userId);

    public List<Content> getUnpurchasedContentListById(int userId);

    public Content getContentById(int id);

    public Content getContentByBuyerIdAndContentId(int buyerID,int contentId);

    public int deleteContentByContentId(int contentId);

    public void publishNewContent(Content content);

    public int updateContent(Content content);
}
