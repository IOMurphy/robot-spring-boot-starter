package io.github.iomurphy.robot.entity.message;

import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;

public abstract class AbstractMessage implements Message {
    private static final long serialVersionUID = 1L;

    private final String msgType;

    public AbstractMessage(MsgTypeEnum msgTypeEnum) {
        this.msgType = msgTypeEnum.getType();
    }

    @Override
    public final String getMsgType() {
        return this.msgType;
    }
}
