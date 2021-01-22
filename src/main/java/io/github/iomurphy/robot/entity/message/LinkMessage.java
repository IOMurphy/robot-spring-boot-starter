package io.github.iomurphy.robot.entity.message;

import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class LinkMessage extends AbstractMessage {
    private static final long serialVersionUID = 1L;

    /**
     * markdown标题
     */
    private String title;
    /**
     * markdown 消息
     */
    private String text;
    /**
     * 照片url
     */
    private String picUrl;
    /**
     * 消息url
     */
    private String messageUrl;

    public LinkMessage() {
        super(MsgTypeEnum.LINK);
    }

    @Override
    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<>();
        map.put("msgtype", getMsgType());
        Map<String, String> link = new HashMap<>();
        link.put("title", title);
        link.put("text", text);
        link.put("picUrl", picUrl);
        link.put("messageUrl", messageUrl);
        map.put("link", link);
        return map;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    @Override
    public String toString() {
        return "LinkMessage{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", messageUrl='" + messageUrl + '\'' +
                '}';
    }
}
