package io.github.iomurphy.robot.config;


import io.github.iomurphy.robot.config.property.DingTalkAuthProperty;
import io.github.iomurphy.robot.config.property.RobotThreadPoolProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * 引入DingTalkAuthProperty配置信息
 *
 * @author IOMurphy
 */
@Configuration
@EnableConfigurationProperties({DingTalkAuthProperty.class, RobotThreadPoolProperties.class})
@Deprecated
public class PropertyConfiguration {

    // 上面显式指明了，下面可以不用new了
//    @Bean
//    public DingTalkAuthProperty dingTalkAuthProperty(){
//        return new DingTalkAuthProperty();
//    }
}
