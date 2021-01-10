package io.github.iomurphy.robot.proerties.dingtalk;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 钉钉的 webhook url
 *
 * @author IOMurphy
 */
@ConfigurationProperties("robot.dingtalk")
public class DingTalkWebHookProperty {
    /**
     * webhook url
     */
    private String webHook;

    public String getWebHook() {
        return webHook;
    }
}
