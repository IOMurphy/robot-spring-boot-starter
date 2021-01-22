package io.github.iomurphy.robot.config;

import io.github.iomurphy.robot.config.property.DingTalkAuthProperty;
import io.github.iomurphy.robot.constants.RobotConstants;
import io.github.iomurphy.robot.convert.DingTalkConverter;
import io.github.iomurphy.robot.core.DingTalkRobotTemplate;
import io.github.iomurphy.robot.except.RobotException;
import io.github.iomurphy.robot.support.DingTalkSignAlgorithm;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 * 钉钉自动装配
 *
 * @author IOMurphy
 */
@Configuration
@ComponentScan
@ConditionalOnMissingBean(name = RobotConstants.DING_TALK_TEMPLATE)
//@AutoConfigureAfter(value = {HttpClientConfiguration.class, PropertyConfiguration.class, DingTalkAuthProperty.class})
/**
 * 这里需要使用@Import是因为 @AutoConfigureAfter(value = { HttpClientConfiguration.class })
 * 只是声明必须在这个之后实例化，没有将HttpClientConfiguration.class注入容器
 */
//@Import(value = {HttpClientConfiguration.class, PropertyConfiguration.class, DingTalkAuthProperty.class})
public class DingTalkAutoConfiguration {


    @Bean
    @ConditionalOnProperty(prefix = RobotConstants.DING_TALK_PROPERTIES_PREFIX, name = "sign")
    public DingTalkSignAlgorithm dingTalkSignAlgorithm(DingTalkAuthProperty dingTalkAuthProperty) throws NoSuchAlgorithmException, InvalidKeyException {
        if (StringUtils.hasText(dingTalkAuthProperty.getSecret())) {
            throw new RobotException("The value of " + RobotConstants.DING_TALK_PROPERTIES_PREFIX + RobotConstants.PROPERTIES_SEPARATOR + "sign can not be empty (or null).");
        }
        return new DingTalkSignAlgorithm(dingTalkAuthProperty.getSecret());
    }

    /**
     * 条件与条件之间是与的关系，
     * 条件判断时配置类的属性尚未注入
     */
    @ConditionalOnMissingBean(DingTalkRobotTemplate.class)
//    @Conditional(DingTalkAuthCondition.class)
    @Bean(name = RobotConstants.DING_TALK_TEMPLATE)
    /**
     * 只要配置文件出现以下属性即可，空不空的不重要
     */
    @ConditionalOnProperty(prefix = RobotConstants.DING_TALK_PROPERTIES_PREFIX, name = "webhook")
    public DingTalkRobotTemplate dingTalkRobotTemplate(DingTalkAuthProperty dingTalkAuthProperty) throws NoSuchAlgorithmException, InvalidKeyException {
        if (StringUtils.hasText(dingTalkAuthProperty.getSecret())) {
            return new DingTalkRobotTemplate(dingTalkAuthProperty, new DingTalkSignAlgorithm(dingTalkAuthProperty.getSecret()));
        }
        return new DingTalkRobotTemplate(dingTalkAuthProperty);
    }


    @Bean(name = "dingTalkConverter")
    @ConditionalOnMissingBean(DingTalkConverter.class)
    public DingTalkConverter dingTalkConverter() {
        return new DingTalkConverter();
    }
}
