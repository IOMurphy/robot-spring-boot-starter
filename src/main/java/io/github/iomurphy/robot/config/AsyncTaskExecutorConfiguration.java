package io.github.iomurphy.robot.config;

import io.github.iomurphy.robot.config.property.RobotThreadPoolProperties;
import io.github.iomurphy.robot.constants.RobotConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * 线程池配置
 *
 * @author IOMurphy
 */
@Configuration
@EnableConfigurationProperties(RobotThreadPoolProperties.class)
public class AsyncTaskExecutorConfiguration {


    @Bean(name = RobotConstants.EXECUTOR)
    @ConditionalOnMissingBean(name = RobotConstants.EXECUTOR)
    @Primary
    // TODO 添加条件判断
    public AsyncTaskExecutor customRobotExector(RobotThreadPoolProperties robotThreadPoolProperties) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(robotThreadPoolProperties.getCoreSize());
        // 最大线程数
        executor.setMaxPoolSize(robotThreadPoolProperties.getMaxSize());
        // 线程最大空闲时间
        executor.setKeepAliveSeconds(robotThreadPoolProperties.getKeepAliveSeconds());
        // 队列大小
        executor.setQueueCapacity(robotThreadPoolProperties.getQueueCapacity());
        // 指定用于新创建的线程名称的前缀
        executor.setThreadNamePrefix(RobotConstants.THREAD_PRE_FIX);
        // 使用自定义拒绝策略, 直接抛出异常
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 等待任务完成时再关闭线程池--表明等待所有线程执行完
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 初始化
        executor.initialize();
        return executor;
    }

    @Bean(name = RobotConstants.EXECUTOR)
    @ConditionalOnMissingBean(name = RobotConstants.EXECUTOR)
    @Primary
    public AsyncTaskExecutor defaultRobotExector() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        // 最大线程数
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 2);
        // 线程最大空闲时间
        executor.setKeepAliveSeconds(10 * 60);
        // 队列大小
        executor.setQueueCapacity(10000);
        // 指定用于新创建的线程名称的前缀
        executor.setThreadNamePrefix(RobotConstants.THREAD_PRE_FIX);
        // 使用自定义拒绝策略, 直接抛出异常
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 等待任务完成时再关闭线程池--表明等待所有线程执行完
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 初始化
        executor.initialize();
        return executor;
    }
}
