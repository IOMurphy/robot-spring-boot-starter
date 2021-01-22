package io.github.iomurphy.robot.config;

import io.github.iomurphy.robot.constants.RobotConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Http client 的配置
 *
 * @author IOMurphy
 */
@Configuration
public class HttpClientConfiguration {

    @Bean(name = RobotConstants.ROBOT_REST_TEMPLATE)
    @ConditionalOnMissingBean(name = RobotConstants.ROBOT_REST_TEMPLATE)
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
