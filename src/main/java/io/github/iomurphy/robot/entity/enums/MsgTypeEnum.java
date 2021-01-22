package io.github.iomurphy.robot.entity.enums;


/**
 * 消息类型枚举
 *
 * @author IOmurphy
 */
public enum MsgTypeEnum {
    TEXT("text"), MARKDOWN("markdown"), LINK("link");
    private final String type;

    MsgTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
