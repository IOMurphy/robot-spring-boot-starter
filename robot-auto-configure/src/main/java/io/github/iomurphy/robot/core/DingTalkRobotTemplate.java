package io.github.iomurphy.robot.core;

import io.github.iomurphy.robot.entity.Request;
import io.github.iomurphy.robot.entity.Response;
import io.github.iomurphy.robot.entity.enums.MessageType;
import io.github.iomurphy.robot.except.UnknownMessageTypeException;
import io.github.iomurphy.robot.proerties.dingtalk.DingTalkWebHookProperty;
import io.github.iomurphy.robot.proerties.dingtalk.auth.DingTalkSignProperty;
import io.github.iomurphy.robot.util.SignUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;


/**
 * 钉钉消息发送模板
 *
 * @author IOMurphy
 */
public class DingTalkRobotTemplate extends AbstractRobotTemplate {

    DingTalkWebHookProperty dingTalkWebHookProperty;
    DingTalkSignProperty dingTalkSignProperty;
    RestTemplate restTemplate;
    SignUtil signUtil;

    public DingTalkRobotTemplate(DingTalkWebHookProperty dingTalkWebHookProperty, DingTalkSignProperty dingTalkSignProperty, RestTemplate restTemplate) {
        this.dingTalkWebHookProperty = dingTalkWebHookProperty;
        this.dingTalkSignProperty = dingTalkSignProperty;
        this.restTemplate = restTemplate;
    }

    public DingTalkRobotTemplate(DingTalkWebHookProperty dingTalkWebHookProperty, DingTalkSignProperty dingTalkSignProperty, SignUtil signUtil, RestTemplate restTemplate) {
        this(dingTalkWebHookProperty, dingTalkSignProperty, restTemplate);
        this.signUtil = signUtil;
    }

    @Override
    public Response send(MessageType messageType, Request request) {
        String url = dingTalkWebHookProperty.getWebHook();
        if(signUtil != null){
            url += signUtil.sign(System.currentTimeMillis());
        }
        switch (messageType){
            case DEFAULT:
                restTemplate.postForObject(dingTalkWebHookProperty.getWebHook(), request, String.class);
                break;
            default:
                throw new UnknownMessageTypeException(messageType.name());
        }
        return null;
    }
}
