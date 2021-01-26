package io.github.iomurphy.robot.entity.message;

import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

abstract class AbstractAtMessage extends AbstractMessage implements Atable, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 被@人的手机号队列
     */
    Queue<String> ids = new LinkedList<>();
    /**
     * 是否@所有人
     */
    boolean atAll = false;

    public AbstractAtMessage(MsgTypeEnum msgTypeEnum) {
        super(msgTypeEnum);
    }

    @Override
    public void at(String id) {
        this.ids.offer(id);
    }

    @Override
    public Queue<String> getAtIds() {
        return this.ids;
    }

    public void setAtIds(Queue<String> ids) {
        this.ids = ids;
    }

    @Override
    public boolean isAtAll() {
        return this.atAll;
    }

    @Override
    public void setAtAll(boolean atAll) {
        this.atAll = atAll;
    }
}
