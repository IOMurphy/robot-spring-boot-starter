package io.github.iomurphy.robot.core;

import io.github.iomurphy.robot.config.property.DingTalkAuthProperty;
import io.github.iomurphy.robot.convert.DingTalkConverter;
import io.github.iomurphy.robot.entity.http.DingTalkResponse;
import io.github.iomurphy.robot.entity.http.Response;
import io.github.iomurphy.robot.entity.message.Message;
import io.github.iomurphy.robot.support.DingTalkSignAlgorithm;
import io.github.iomurphy.robot.support.SignResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


/**
 * 钉钉消息发送模板
 *
 * @author IOMurphy
 */
public class DingTalkRobotTemplate extends AbstractRobotTemplate {

    Logger logger = LoggerFactory.getLogger(DingTalkRobotTemplate.class);
    @Autowired
    DingTalkConverter converter;
    @Autowired
    RestTemplate restTemplate;
    DingTalkSignAlgorithm algorithm;

    String webhookUrl;

    public DingTalkRobotTemplate(DingTalkAuthProperty dingTalkAuthProperty, DingTalkSignAlgorithm dingTalkSignAlgorithm) {
        this.webhookUrl = dingTalkAuthProperty.getWebhook();
        this.algorithm = dingTalkSignAlgorithm;
    }

    public DingTalkRobotTemplate(DingTalkAuthProperty dingTalkAuthProperty) {
        this.webhookUrl = dingTalkAuthProperty.getWebhook();
        this.algorithm = null;
    }


    @Override
    public Response send(Message message) {
        logger.debug("The request content is " + message);
        Map<String, Object> convertedMessage = converter.convert(message);
        logger.debug("The converted request content is " + message);
        DingTalkResponse dingTalkResponse = restTemplate.postForObject(signUrl(), convertedMessage, DingTalkResponse.class);
        logger.info("The response is " + dingTalkResponse);
        return dingTalkResponse;
    }

    @NonNull
    private String signUrl() {
        String url = webhookUrl;
        SignResult signResult = null;
        if (algorithm != null) {
            signResult = algorithm.sign(System.currentTimeMillis());
            url = url + "&timestamp=" + signResult.getTimestamp() + "&sign=" + signResult.getSignature();
        }
        logger.debug("The webhook url is " + url);
        return url;
    }

}
