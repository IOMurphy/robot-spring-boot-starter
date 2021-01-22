package io.github.iomurphy.robot.convert;

import io.github.iomurphy.robot.entity.message.Message;

/**
 * 消息转换器
 *
 * @param <T>
 * @author IOMurphy
 */
public interface MessageConverter<T> {
    T convert(Message message);
}
