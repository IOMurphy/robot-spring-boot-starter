package io.github.iomurphy.robot.proerties.dingtalk.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 通过加签方式认证
 *
 * @author IOMurphy
 */
@ConfigurationProperties("robot.dingtalk.auth")
public class DingTalkSignProperty {
    /**
     * 钉钉中加签字段
     */
    private String sign;

    public String getSign() {
        return sign;
    }
}
