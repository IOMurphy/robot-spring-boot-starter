package io.github.iomurphy.robot.except;

import io.github.iomurphy.robot.entity.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendingMessageException extends RobotException {
    private Logger logger = LoggerFactory.getLogger(SendingMessageException.class);
    public SendingMessageException(Response response) {
        super(response.getErrMsg());
        logger.error("消息发送错误，错误内容为{}", response);
    }
}
