package io.github.iomurphy.robot.core;

import io.github.iomurphy.robot.entity.Request;
import io.github.iomurphy.robot.entity.Response;
import io.github.iomurphy.robot.entity.enums.MessageType;

public interface RobotTemplate {



    /**
     * 发送消息
     * @param request 发送的消息
     * @return 发送结果
     */
    Response send(Request request);

    /**
     * 指明消息类型发送消息
     * @param messageType 消息类型
     * @param request 发送的消息
     * @return 发送结果
     */
    Response send(MessageType messageType, Request request);
}
