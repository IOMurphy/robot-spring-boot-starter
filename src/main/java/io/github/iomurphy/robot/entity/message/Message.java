package io.github.iomurphy.robot.entity.message;

import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;
import org.springframework.lang.NonNull;

import java.util.LinkedList;
import java.util.List;

/**
 * 发送的消息
 *
 * @author IOMurphy
 */
public class Message {
    /**
     * 消息类型
     */
    @NonNull
    private MsgTypeEnum msgType = MsgTypeEnum.TEXT;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 标题
     */
    private String title;
    /**
     * 被@的人的电话
     */
    private List<String> phones = new LinkedList<>();
    /**
     * 艾特所有人
     */
    private boolean atAll = false;

    private Message() {
    }

    /**
     * 构造器模式
     *
     * @author IOMurphy
     */
    static public class Builder {
        private final Message message;

        public Builder() {
            this.message = new Message();
        }

        public Builder msgType(MsgTypeEnum msgType) {
            message.setMsgType(msgType);
            return this;
        }

        public Builder content(String content) {
            message.setContent(content);
            return this;
        }

        public Builder title(String title) {
            message.setTitle(title);
            return this;
        }

        public Builder phones(List<String> phones) {
            message.setPhones(phones);
            return this;
        }

        public Builder at(String phone) {
            message.phones.add(phone);
            return this;
        }

        public Builder atAll(boolean atAll) {
            message.setAtAll(atAll);
            return this;
        }

        public Message build() {
            return message;
        }
    }

    public void setMsgType(MsgTypeEnum msgType) {
        this.msgType = msgType;
    }

    public MsgTypeEnum getMsgType() {
        return msgType;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public boolean isAtAll() {
        return atAll;
    }

    public void setAtAll(boolean atAll) {
        this.atAll = atAll;
    }

    @Override
    public String toString() {
        return "Request{" +
                "content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", phones=" + phones +
                ", atAll=" + atAll +
                '}';
    }
}