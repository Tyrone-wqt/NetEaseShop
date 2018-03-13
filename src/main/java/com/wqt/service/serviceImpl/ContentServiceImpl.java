package com.wqt.service.serviceImpl;

import com.wqt.dao.ContentDao;
import com.wqt.pojo.Content;
import com.wqt.service.ContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/3/7.
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService{
    @Resource
    private ContentDao contentDao;
    @Override
    public List<Content> getAllContentList() {
        return contentDao.getAllContentList();
    }

    @Override
    public List<Content> getSellerContentListById(int userId) {
        return contentDao.getSellerContentListById(userId);
    }

    @Override
    public List<Content> getBuyerContentListById(int userId) {
        return contentDao.getBuyerContentListById(userId);
    }

    @Override
    public List<Content> getUnpurchasedContentListById(int userId) {
        return contentDao.getUnpurchasedContentListById(userId);
    }

    @Override
    public Content getContentById(int id) {
        return contentDao.getContentById(id);
    }

    @Override
    public Content getContentByBuyerIdAndContentId(int buyerID, int contentId) {
        return contentDao.getContentByBuyerIdAndContentId(buyerID,contentId);
    }

    @Override
    public int deleteContentByContentId(int contentId) {
        return contentDao.deleteContentByContentId(contentId);
    }

    @Override
    public void publishNewContent(Content content) {
        contentDao.insertContent(content);
    }

    @Override
    public int updateContent(Content content) {
        return contentDao.updateContent(content);
    }


}
