package com.wqt.dao;

import com.wqt.pojo.Content;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/3/7.
 */
public interface ContentDao {
    public List<Content> getAllContentList();

    public List<Content> getSellerContentListById(int userId);

    public List<Content> getBuyerContentListById(int userId);

    public List<Content> getUnpurchasedContentListById(int userId);

    public Content getContentById(int concentId);

    public Content getContentByBuyerIdAndContentId(@Param("buyerId")int buyerId,@Param("contentId")int contentId);

    public int deleteContentByContentId(int contentId);

    public void insertContent(Content content);

    public int updateContent(Content content);

}
