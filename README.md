## 钉钉/微信消息机器人中间件

[![license](https://img.shields.io/badge/license-Apache%20License%202.0-brightgreen.svg?style=flat)](https://github.com/murphy-li/Clipboard2Voice/blob/master/LICENSE)
[![Release Version](https://img.shields.io/badge/snapshot-v0.0.1-red.svg)](https://github.com/IOMurphy/robot-spring-boot-starter/release)

本软件旨在提供一个包含钉钉以及微信的消息中间件，帮助开发在项目中迅速引入IM工具。

## 一、进度

✅ 自动注入RobotTemplate

✅ 钉钉

❌ 微信

❌ 上传到[中央仓库](https://mvnrepository.com/)

已支持的钉钉消息类型

|消息类型|支持与否|
|-------|----|
|文本消息| ✅|
|markdown消息|✅|
|链接消息（过时）|✅|
|独立的ActionCard|✅|
|整体的ActionCard|✅|
|FeedCard|✅|

## 二、使用教程

### 2.1 准备工作

引入项目依赖（尚未上传到中央仓库，所以只能自己本地构建）

```dtd

<dependency>
    <groupId>io.github.iomurphy</groupId>
    <artifactId>robot-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

在配置文件中添加以下配置：

```properties
# 钉钉机器人的webhook链接，替换${token}
robot.dingtalk.webhook=https://oapi.dingtalk.com/robot/send?access_token=${token}
# 钉钉机器人的secret，替换${secret}，如果不使用加签方式这里不用填
robot.dingtalk.secret=${secret}
# 消息级别
logging.level.root=INFO
# 线程池参数
robot.thread-pool.core-size=1
robot.thread-pool.max-size=2
robot.thread-pool.keep-alive-seconds=600
robot.thread-pool.queue-capacity=1000
```

在Spring Boot中注入机器人模板：

```java
@Autowired
RobotTemplate robotTemplate;
```

### 2.2 发送钉钉消息

#### 2.2.1 文本消息

构建消息并发送：

```java
    void sendTextMessage(){
        TextMessage message=new TextMessage();
        message.setContent("我就是我, 是不一样的烟火@156xxxx8827");
        message.at("156xxxx8827");
        message.at("189xxxx8325");
        message.setAtAll(false);
        Response response=robotTemplate.send(message);
        if(response.getErrCode()!=0){
            throw new RuntimeException(response.toString());
        }
    }
```

效果图：

![TextMessage](https://static-aliyun-doc.oss-accelerate.aliyuncs.com/assets/img/zh-CN/4099076061/p131215.png)

#### 2.2.2 markdown消息

构建消息并发送：

```java
    void sendMarkdownDingTalkMessage(){
        MarkdownMessage message=new MarkdownMessage();
        message.setText("#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingtalk.com) \n");
        message.setTitle("杭州天气");
        message.at("150XXXXXXXX");
        message.setAtAll(false);
        Response response=robotTemplate.send(message);
        if(response.getErrCode()!=0){
            throw new RuntimeException(response.toString());
        }
    }
```

效果图：

![MarkdownDingTalkMessage](https://static-aliyun-doc.oss-accelerate.aliyuncs.com/assets/img/zh-CN/4099076061/p131216.png)

#### 2.2.3 整体跳转 ActionCard

构建消息并发送：

```java
    void sendWholeActionCardMessage(){
        WholeActionCard message=new WholeActionCard();
        message.setText("![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png) \n"+
        " ### 乔布斯 20 年前想打造的苹果咖啡厅 \n"+
        " Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划");
        message.setTitle("乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身");
        message.setBtnOrientation(Button.BtnOrientation.HORIZONTAL);
        message.setSingleTitle("阅读全文");
        message.setSingleURL("https://www.dingtalk.com/");
        Response response=robotTemplate.send(message);
        if(response.getErrCode()!=0){
            throw new RuntimeException(response.toString());
        }
    }
```

效果图：

![ActionCard](https://static-aliyun-doc.oss-accelerate.aliyuncs.com/assets/img/zh-CN/5099076061/p131217.png)

#### 2.2.4 独立跳转 ActionCard

构建消息并发送：

```java
    void sendIndependentActionCardMessage(){
        IndependentActionCard message=new IndependentActionCard();
        message.setText("![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png) \n"+
        " ### 乔布斯 20 年前想打造的苹果咖啡厅 \n"+
        " Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划");
        message.setTitle("乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身");
        message.setBtnOrientation(Button.BtnOrientation.HORIZONTAL);
        message.addButton(new Button("内容不错","https://www.dingtalk.com/"));
        message.addButton(new Button("不感兴趣","https://www.dingtalk.com/"));
        Response response=robotTemplate.send(message);
        if(response.getErrCode()!=0){
            throw new RuntimeException(response.toString());
        }
    }
```

效果图：

![ActionCard](https://static-aliyun-doc.oss-accelerate.aliyuncs.com/assets/img/zh-CN/5099076061/p131218.png)

#### 2.2.5 FeedCard

构建消息并发送：

```java
    void sendFeedCardMessage(){
        FeedCard message=new FeedCard();
        message.addLink(new Link("时代的火车向前开","https://meeting.dingtalk.com/app?spm=a213l2.13146415.4929779444.110.7f1521c9fqUNVl&acm=lb-zebra-522635-9150460.1003.4.8899223&scm=1003.4.lb-zebra-522635-9150460.OTHER_16100607822421_8899223","https://img.alicdn.com/imgextra/i4/O1CN01hVN23L1EmUhpVvNBk_!!6000000000394-2-tps-146-146.png"));
        message.addLink(new Link("时代的火车向前开2","https://www.baidu.com","https://img.alicdn.com/imgextra/i2/O1CN01vj0PSK1QKLkvuqeC2_!!6000000001957-2-tps-146-146.png"));
        Response response=robotTemplate.send(message);
        if(response.getErrCode()!=0){
            throw new RuntimeException(response.toString());
        }
    }
```

效果图：

![FeedCard](https://static-aliyun-doc.oss-accelerate.aliyuncs.com/assets/img/zh-CN/5099076061/p131219.png)

#### 2.2.6 链接消息

构建消息并发送：

```java
    @Deprecated
    void sendLinkMessage(){
        LinkMessage message=new LinkMessage();
        message.setText("这个即将发布的新版本，创始人xx称它为红树林。而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是红树林");
        message.setTitle("时代的火车向前开");
        message.setPicUrl("");
        message.setMessageUrl("bing.com");
        Response response=robotTemplate.send(message);
        if(response.getErrCode()!=0){
            throw new RuntimeException(response.toString());
        }
    }
```

根据钉钉最新文档，链接类型的消息已经不支持了。

### 2.3 发送微信消息

尚未支持，抽时间适配中。

## License

本软件使用[Apache License 2.0](https://github.com/IOMurphy/https://github.com/IOMurphy/robot-spring-boot-starter/blob/main/LICENSE)
发布。