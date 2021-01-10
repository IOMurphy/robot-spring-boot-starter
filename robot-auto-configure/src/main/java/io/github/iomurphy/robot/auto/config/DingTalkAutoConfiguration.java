package io.github.iomurphy.robot.auto.config;

import io.github.iomurphy.robot.core.DingTalkRobotTemplate;
import io.github.iomurphy.robot.core.RobotTemplate;
import io.github.iomurphy.robot.proerties.dingtalk.DingTalkWebHookProperty;
import io.github.iomurphy.robot.proerties.dingtalk.auth.DingTalkSignProperty;
import io.github.iomurphy.robot.util.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@EnableAutoConfiguration
@EnableConfigurationProperties({DingTalkWebHookProperty.class, DingTalkSignProperty.class})
public class DingTalkAutoConfiguration {

    @Autowired
    DingTalkWebHookProperty dingTalkWebHookProperty;
    @Autowired
    DingTalkSignProperty dingTalkSignProperty;

    @Bean
    @ConditionalOnMissingBean(DingTalkRobotTemplate.class)
    public RobotTemplate robotTemplate(RestTemplate restTemplate) throws NoSuchAlgorithmException, InvalidKeyException {
        if (StringUtils.hasText(dingTalkSignProperty.getSign())) {
            SignUtil signUtil = SignUtil.getInstance(dingTalkSignProperty.getSign());
            return new DingTalkRobotTemplate(dingTalkWebHookProperty, dingTalkSignProperty, signUtil, restTemplate);
        }
        return new DingTalkRobotTemplate(dingTalkWebHookProperty, dingTalkSignProperty, restTemplate);
    }
}
