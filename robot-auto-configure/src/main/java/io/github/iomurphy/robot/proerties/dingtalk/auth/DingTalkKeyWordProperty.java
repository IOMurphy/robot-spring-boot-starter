package io.github.iomurphy.robot.proerties.dingtalk.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 通过关键字的方式认证，但是理论上在消息内包含
 *
 * @author IOMurphy
 */
@ConfigurationProperties("robot.dingtalk.auth")
@Deprecated
public class DingTalkKeyWordProperty {
    /**
     * 钉钉关键词
     */
    private List<String> keyWords;
}
