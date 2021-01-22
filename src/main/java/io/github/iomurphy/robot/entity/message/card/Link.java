package io.github.iomurphy.robot.entity.message.card;


public class Link {
    /**
     * 链接标题
     */
    String title;
    /**
     * 消息url
     */
    String messageUrl;
    /**
     * 照片url
     */
    String picUrl;

    public Link(String title, String messageUrl, String picUrl) {
        this.title = title;
        this.messageUrl = messageUrl;
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}