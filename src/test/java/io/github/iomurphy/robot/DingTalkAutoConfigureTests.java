package io.github.iomurphy.robot;

import io.github.iomurphy.robot.core.RobotTemplate;
import io.github.iomurphy.robot.entity.card.*;
import io.github.iomurphy.robot.entity.http.Response;
import io.github.iomurphy.robot.entity.message.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DingTalkAutoConfigureTests.class})
@EnableAutoConfiguration
class DingTalkAutoConfigureTests {


    @Autowired
    RobotTemplate robotTemplate;

    @Test
    void sendTextMessage() {
        TextMessage message = new TextMessage();
        message.setContent("我就是我, 是不一样的烟火@156xxxx8827");
        message.at("156xxxx8827");
        message.at("189xxxx8325");
        message.setAtAll(false);
        Response response = robotTemplate.send(message);
        if(response.getErrCode() != 0){
            throw new RuntimeException(response.toString());
        }
    }

    @Test
    void sendMarkdownDingTalkMessage() {
        MarkdownMessage message = new MarkdownMessage();
        message.setText("#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingtalk.com) \n");
        message.setTitle("杭州天气");
        message.at("150XXXXXXXX");
        message.setAtAll(false);
        Response response = robotTemplate.send(message);
        if (response.getErrCode() != 0) {
            throw new RuntimeException(response.toString());
        }
    }

    @Test
    void sendLinkMessage() {
        LinkMessage message = new LinkMessage();
        message.setText("这个即将发布的新版本，创始人xx称它为红树林。而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是红树林");
        message.setTitle("时代的火车向前开");
        message.setPicUrl("");
        message.setMessageUrl("bing.com");
        Response response = robotTemplate.send(message);
        if (response.getErrCode() != 0) {
            throw new RuntimeException(response.toString());
        }
    }

    @Test
    void sendWholeActionCardMessage() {
        WholeActionCard message = new WholeActionCard();
        message.setText("![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png) \n" +
                " ### 乔布斯 20 年前想打造的苹果咖啡厅 \n" +
                " Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划");
        message.setTitle("乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身");
        message.setBtnOrientation(Button.BtnOrientation.HORIZONTAL);
        message.setSingleTitle("阅读全文");
        message.setSingleURL("https://www.dingtalk.com/");
        Response response = robotTemplate.send(message);
        if (response.getErrCode() != 0) {
            throw new RuntimeException(response.toString());
        }
    }

    @Test
    void sendIndependentActionCardMessage() {
        IndependentActionCard message = new IndependentActionCard();
        message.setText("![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png) \n" +
                " ### 乔布斯 20 年前想打造的苹果咖啡厅 \n" +
                " Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划");
        message.setTitle("乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身");
        message.setBtnOrientation(Button.BtnOrientation.HORIZONTAL);
        message.addButton(new Button("内容不错", "https://www.dingtalk.com/"));
        message.addButton(new Button("不感兴趣", "https://www.dingtalk.com/"));
        Response response = robotTemplate.send(message);
        if (response.getErrCode() != 0) {
            throw new RuntimeException(response.toString());
        }
    }

    @Test
    void sendFeedCardMessage() {
        FeedCard message = new FeedCard();
        message.addLink(new Link("时代的火车向前开", "https://meeting.dingtalk.com/app?spm=a213l2.13146415.4929779444.110.7f1521c9fqUNVl&acm=lb-zebra-522635-9150460.1003.4.8899223&scm=1003.4.lb-zebra-522635-9150460.OTHER_16100607822421_8899223", "https://img.alicdn.com/imgextra/i4/O1CN01hVN23L1EmUhpVvNBk_!!6000000000394-2-tps-146-146.png"));
        message.addLink(new Link("时代的火车向前开2", "https://www.baidu.com", "https://img.alicdn.com/imgextra/i2/O1CN01vj0PSK1QKLkvuqeC2_!!6000000001957-2-tps-146-146.png"));
        Response response = robotTemplate.send(message);
        if (response.getErrCode() != 0) {
            throw new RuntimeException(response.toString());
        }
    }

}
