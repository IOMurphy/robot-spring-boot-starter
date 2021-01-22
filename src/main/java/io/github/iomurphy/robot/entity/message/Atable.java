package io.github.iomurphy.robot.entity.message;

import java.util.Queue;

/**
 * 可@的消息
 */
public interface Atable {
    /**
     * @param id
     * @某个人
     */
    void at(String id);

    /**
     * 获取@队列
     *
     * @return @队列
     */
    Queue<String> getAtIds();

    /**
     * 设置@队列
     *
     * @param ids
     */
    void setAtIds(Queue<String> ids);

    /**
     * 是否@所有人
     *
     * @return
     */
    boolean isAtAll();

    /**
     * 设置是否@所有人
     *
     * @param atAll
     */
    void setAtAll(boolean atAll);
}
