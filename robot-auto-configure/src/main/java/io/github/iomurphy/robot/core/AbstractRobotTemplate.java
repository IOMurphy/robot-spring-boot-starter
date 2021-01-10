package io.github.iomurphy.robot.core;

import io.github.iomurphy.robot.entity.Request;
import io.github.iomurphy.robot.entity.Response;
import io.github.iomurphy.robot.entity.enums.MessageType;
import org.springframework.web.client.RestTemplate;


/**
 * 消息发送器的抽象类
 *
 * @author IOMurphy
 */
public abstract class AbstractRobotTemplate implements RobotTemplate{

    @Override
    public Response send(Request request) {
        return send(MessageType.DEFAULT, request);
    }
}
