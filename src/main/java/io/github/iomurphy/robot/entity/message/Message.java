package io.github.iomurphy.robot.entity.message;

import java.io.Serializable;
import java.util.Map;

public interface Message extends Serializable {
    /**
     * 获取消息类型
     *
     * @return
     */
    String getMsgType();

    /**
     * 消息转换为json
     *
     * @return
     */
    Map<String, Object> map();
}
