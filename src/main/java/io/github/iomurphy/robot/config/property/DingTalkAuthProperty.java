package io.github.iomurphy.robot.config.property;


import io.github.iomurphy.robot.constants.RobotConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;

/**
 * 钉钉认证属性
 *
 * @author IOMurphy
 */
@ConfigurationProperties(prefix = RobotConstants.DING_TALK_PROPERTIES_PREFIX)
public class DingTalkAuthProperty {
    /**
     * webhook url
     */
    @Nullable
    private String webhook;
    /**
     * 钉钉中加签字段
     */
    @Nullable
    private String secret;

    @Nullable
    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(@Nullable String webhook) {
        this.webhook = webhook;
    }

    @Nullable
    public String getSecret() {
        return secret;
    }

    public void setSecret(@Nullable String secret) {
        this.secret = secret;
    }
}
