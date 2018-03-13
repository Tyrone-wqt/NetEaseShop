
import com.wqt.pojo.Cart;
import com.wqt.pojo.Content;
import com.wqt.pojo.Order;
import com.wqt.service.CartService;
import com.wqt.service.ContentService;
import com.wqt.service.OrdersService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/3/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);

    @Resource
    private ContentService contentService=null;
    @Resource
    private CartService cartService;
    @Resource
    private OrdersService ordersService;

    @Test
    public void test2(){
        List<Content> contents=contentService.getBuyerContentListById(2);
        if(contents==null) logger.info("contents is null");
        for(Content content:contents){
            System.out.println("id: "+content.getId());
            System.out.println("title: "+content.getcTitle());
            System.out.println("abstract: "+content.getcAbstract());
            System.out.println("text: "+content.getcText());
            System.out.println("imgUrl: "+content.getcImgUrl());
            System.out.println("price: "+content.getcPrice());
            System.out.println("tag: "+content.getTag());

        }
    }
    @Test
    public void test3(){
        List<Content> contents=contentService.getSellerContentListById(2);
        if(contents==null) logger.info("contents is null");
        for(Content content:contents){
            System.out.println("id: "+content.getId());
            System.out.println("title: "+content.getcTitle());
            System.out.println("abstract: "+content.getcAbstract());
            System.out.println("text: "+content.getcText());
            System.out.println("imgUrl: "+content.getcImgUrl());
            System.out.println("price: "+content.getcPrice());
            System.out.println("tag: "+content.getTag());
            System.out.println("------------------------");
        }
    }
    @Test
    public void test4(){
        List<Content> contents=contentService.getUnpurchasedContentListById(2);
        if(contents==null) logger.info("contents is null");
        for(Content content:contents){
            System.out.println("id: "+content.getId());
            System.out.println("title: "+content.getcTitle());
            System.out.println("abstract: "+content.getcAbstract());
            System.out.println("text: "+content.getcText());
            System.out.println("imgUrl: "+content.getcImgUrl());
            System.out.println("price: "+content.getcPrice());
            System.out.println("tag: "+content.getTag());
            System.out.println("------------------------");
        }
    }
    @Test
    public void test5(){
        List<Content> contents=contentService.getBuyerContentListById(1);
        if(contents==null) logger.info("contents is null");
        System.out.println("买家内容列表");
        for (Content c : contents) {
            System.out.println(c.getId());
            System.out.println("tag==" + c.getTag());
            System.out.println("--------");
        }
    }
    @Test
    public void test6(){
        Content content=null;
        for(int i=1;i<=4;i++){
            content=contentService.getContentById(i);
            logger.info("id: "+content.getId());
            logger.info("title: "+content.getcTitle());
            logger.info("tag: "+content.getTag());

        }
    }
    @Test
    public void test7(){
        Content content=null;
        content=contentService.getContentByBuyerIdAndContentId(1,3);
        logger.info("id: "+content.getId());
        logger.info("title: "+content.getcTitle());
        logger.info("tag: "+content.getTag());
    }

    @Test
    public void test8(){
        cartService.addContentById(1,1,50);
    }

    @Test
    public void test9(){
        List<Cart> cartItemList=cartService.getCartListByUserId(1);
        if(cartItemList!=null){
            for(Cart cartItem:cartItemList){
                logger.info(cartItem.getContent().getcText());
                logger.info(cartItem.getContent().getcPrice());
                logger.info(cartItem.getCount());
                logger.info("---------------");
            }
        }
    }

    @Test
    public void test10(){
        List<Order> orderList=ordersService.getOrderListByUserId(1);
        if(orderList!=null){
            for(Order order:orderList){
                logger.info(order.getContent().getcTitle());
                logger.info(order.getDate());
                logger.info(order.getPrice());
                logger.info(order.getCount());
                logger.info("---------------");
            }
        }

    }
    @Test
    public void test11(){
        System.out.println(System.getProperty("path.separator"));
        System.out.println(java.io.File.separator);
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("line.separator"));
    }

    @Test
    public void test12(){
        Content content=new Content();
        content.setcAbstract("摘要1");
        content.setcTitle("标题1");
        content.setcText("文本1");
        content.setSid(1);
        content.setcImgUrl("1");
        content.setcPrice(1);
        contentService.publishNewContent(content);
    }

    @Test
    public void test13(){
        List<Content> contentList=contentService.getBuyerContentListById(1);
        for (Content c : contentList) {
            System.out.println(c.getId());
            System.out.println("tag==" + c.getTag());
            System.out.println("--------");
        }
    }


}
