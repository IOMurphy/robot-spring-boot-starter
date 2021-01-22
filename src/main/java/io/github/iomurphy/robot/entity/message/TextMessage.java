package io.github.iomurphy.robot.entity.message;

import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class TextMessage extends AbstractAtMessage {
    private static final long serialVersionUID = 1L;

    /**
     * 消息内容
     */
    private String content;

    public TextMessage() {
        super(MsgTypeEnum.TEXT);
    }

    @Override
    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<>();
        map.put("msgtype", getMsgType());
        Map<String, String> text = new HashMap<>();
        text.put("content", content);
        map.put("text", text);
        Map<String, Object> at = new HashMap<>();
        at.put("atMobiles", getAtIds());
        at.put("isAtAll", isAtAll());
        map.put("at", at);
        return map;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "ids=" + ids +
                ", atAll=" + atAll +
                ", content='" + content + '\'' +
                '}';
    }
}
