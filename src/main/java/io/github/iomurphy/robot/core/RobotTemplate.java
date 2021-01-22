package io.github.iomurphy.robot.core;

import io.github.iomurphy.robot.entity.http.Response;
import io.github.iomurphy.robot.entity.message.Message;

import java.util.concurrent.Future;

/**
 * 机器人模板类
 *
 * @author IOmurphy
 */
public interface RobotTemplate {

    /**
     * 发送消息
     * @param message 发送的消息
     * @return 发送结果
     */
    Response send(Message message);

    /**
     * 指明消息类型发送消息
     * @param message 发送的消息
     * @return 发送结果
     */
    Future<Response> aSyncSend(Message message);
}
