package io.github.iomurphy.robot.config.condition;

import io.github.iomurphy.robot.config.DingTalkAutoConfiguration;
import io.github.iomurphy.robot.constants.RobotConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
 * 属性条件查找类
 * 如果不是使用静态内部类会报错找不到类的默认构造函数，使用静态类就好了
 *
 * @author IOMurphy
 */
@Deprecated
public class DingTalkAuthCondition implements Condition {

    Logger logger = LoggerFactory.getLogger(DingTalkAutoConfiguration.class);

    public DingTalkAuthCondition() {
        super();
    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String dingTalkWebhook = conditionContext.getEnvironment().getProperty(RobotConstants.DING_TALK_PROPERTIES_PREFIX + RobotConstants.PROPERTIES_SEPARATOR + "webhook");
        if (StringUtils.hasText(dingTalkWebhook)) {
            logger.debug("Found property " + RobotConstants.DING_TALK_PROPERTIES_PREFIX + RobotConstants.PROPERTIES_SEPARATOR + " webhook with value " + dingTalkWebhook + ".");
            return true;
        }
        logger.warn("Could not find property " + RobotConstants.DING_TALK_PROPERTIES_PREFIX + RobotConstants.PROPERTIES_SEPARATOR + "webhook");
        return false;
    }
}
