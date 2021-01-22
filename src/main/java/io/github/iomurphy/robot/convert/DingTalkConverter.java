package io.github.iomurphy.robot.convert;

import io.github.iomurphy.robot.constants.RobotConstants;
import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;
import io.github.iomurphy.robot.entity.message.Message;
import io.github.iomurphy.robot.except.UnSupportMessageTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * 钉钉消息转换
 *
 * @author IOMurphy
 */
public class DingTalkConverter implements MessageConverter<Map<String, Object>> {

    Logger logger = LoggerFactory.getLogger(DingTalkConverter.class);

    @Override
    public Map<String, Object> convert(Message message) {
        Map<String, Object> map = new HashMap<>();
        MsgTypeEnum msgType = message.getMsgType();
        map.put(RobotConstants.MSG_TYPE, msgType.getType());
        switch (msgType) {
            case TEXT:
                Map<String, String> text = new HashMap<>(3);
                text.put(RobotConstants.CONTENT, message.getContent());
                map.put(RobotConstants.TEXT, text);
                if (StringUtils.hasText(message.getTitle())) {
                    logger.warn("The title is not work when message type is " + msgType.getType() + ".（当消息类型为" + msgType.getType() + "时，标题不可用。）");
                }
                break;
            case MARKDOWN:
                Map<String, String> markdown = new HashMap<>(3);
                markdown.put(RobotConstants.TEXT, message.getContent());
                markdown.put(RobotConstants.TITLE, message.getTitle());
                map.put(RobotConstants.MARKDOWN, markdown);
                break;
            case LINK:
                /**
                 * 支持得差
                 */
                Map<String, String> link = new HashMap<>(3);
                link.put(RobotConstants.TEXT, message.getContent());
                link.put(RobotConstants.TITLE, message.getTitle());
                map.put(RobotConstants.LINK, link);
            default:
                throw new UnSupportMessageTypeException(message.getMsgType().getType());
        }
        Map<String, Object> at = new HashMap<>(5);
        at.put(RobotConstants.AT_MOBILES, message.getPhones());
        at.put(RobotConstants.IS_AT_ALL, message.isAtAll());
        map.put(RobotConstants.AT, at);
        return map;
    }
}
