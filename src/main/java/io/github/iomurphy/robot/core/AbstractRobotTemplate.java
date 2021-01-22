package io.github.iomurphy.robot.core;


import io.github.iomurphy.robot.entity.http.Response;
import io.github.iomurphy.robot.entity.message.Message;
import io.github.iomurphy.robot.except.RobotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Future;

/**
 * 消息发送器的抽象类
 *
 * @author IOMurphy
 */
public abstract class AbstractRobotTemplate implements RobotTemplate {

    @Autowired
    AsyncTaskExecutor executor;

    @Override
    public Future<Response> aSyncSend(Message message) throws RobotException {
        return executor.submit(() -> send(message));
    }
}
