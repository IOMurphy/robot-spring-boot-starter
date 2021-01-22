package io.github.iomurphy.robot.entity.message;

import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class MarkdownMessage extends AbstractAtMessage {
    private static final long serialVersionUID = 1L;

    /**
     * markdown标题
     */
    private String title;
    /**
     * markdown 消息
     */
    private String text;

    public MarkdownMessage() {
        super(MsgTypeEnum.MARKDOWN);
    }

    public MarkdownMessage(MsgTypeEnum msgTypeEnum) {
        super(msgTypeEnum);
    }

    @Override
    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<>();
        map.put("msgtype", getMsgType());
        Map<String, String> markdown = new HashMap<>();
        markdown.put("title", title);
        markdown.put("text", text);
        map.put("markdown", markdown);
        Map<String, Object> at = new HashMap<>();
        at.put("atMobiles", getAtIds());
        at.put("isAtAll", isAtAll());
        map.put("at", at);
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

    @Override
    public String toString() {
        return "MarkdownMessage{" +
                "ids=" + ids +
                ", atAll=" + atAll +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
