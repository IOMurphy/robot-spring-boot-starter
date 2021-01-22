package io.github.iomurphy.robot;

import io.github.iomurphy.robot.core.RobotTemplate;
import io.github.iomurphy.robot.entity.message.Message;
import io.github.iomurphy.robot.entity.http.Response;
import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootTest(classes = {DingTalkAutoConfigureTests.HttpConvertConfiguration.class})
@EnableAutoConfiguration
class DingTalkAutoConfigureTests {

    @Configuration
    static class HttpConvertConfiguration {
        @Bean
        public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
            return new MappingJackson2HttpMessageConverter();
        }
    }

    @Autowired
    RobotTemplate robotTemplate;

    @Test
    void sendTextDingTalkMessage() {
        Message.Builder builder = new Message.Builder();
        Message message = builder.atAll(false).at("13333333333").content("文本消息").msgType(MsgTypeEnum.TEXT).title("java").build();
        Response response = robotTemplate.send(message);
        if(response.getErrCode() != 0){
            throw new RuntimeException(response.toString());
        }
    }

    @Test
    void sendMarkdownDingTalkMessage() {
        Message.Builder builder = new Message.Builder();
        Message message = builder.atAll(true).title("Markdown 标题").content("# Markdown\n# Markdown").msgType(MsgTypeEnum.MARKDOWN).build();
        Response response = robotTemplate.send(message);
        if(response.getErrCode() != 0){
            throw new RuntimeException(response.toString());
        }
    }

}
