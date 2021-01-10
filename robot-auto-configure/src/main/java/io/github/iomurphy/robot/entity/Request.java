package io.github.iomurphy.robot.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * 发送的消息
 *
 * @author IOMurphy
 */
public class Request {
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

    public Request() {
    }

    /**
     * 构造器模式
     *
     * @author IOMurphy
     */
    static public class Builder {
        private Request request;

        public Builder() {
            this.request = new Request();
        }

        public Builder content(String content) {
            request.setContent(content);
            return this;
        }

        public Builder title(String title) {
            request.setTitle(title);
            return this;
        }

        public Builder phones(List<String> phones) {
            request.setPhones(phones);
            return this;
        }

        public Builder atAll(boolean atAll) {
            request.setAtAll(atAll);
            return this;
        }

        public Request build() {
            return request;
        }
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
}