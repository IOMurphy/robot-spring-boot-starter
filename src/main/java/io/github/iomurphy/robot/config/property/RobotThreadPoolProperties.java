package io.github.iomurphy.robot.config.property;

import io.github.iomurphy.robot.constants.RobotConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 机器人线程池
 *
 * @author IOMurphy
 */
@ConfigurationProperties(RobotConstants.ROBOT_THREAD_POOL_PROPERTIES_PREFIX)
public class RobotThreadPoolProperties {
    private int coreSize;
    private int maxSize;
    private int keepAliveSeconds;
    private int queueCapacity;

    public int getCoreSize() {
        return coreSize;
    }

    public void setCoreSize(int coreSize) {
        this.coreSize = coreSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
}
