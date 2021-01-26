package io.github.iomurphy.robot.entity.card;


public class Link {
    /**
     * 信息文本
     */
    String title;
    /**
     * 信息跳转链接
     */
    String messageUrl;
    /**
     * 信息后面图片的URL
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