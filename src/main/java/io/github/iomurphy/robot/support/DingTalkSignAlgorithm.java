package io.github.iomurphy.robot.support;

import io.github.iomurphy.robot.except.RobotException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


/**
 * 钉钉签名算法类
 *
 * @author IOMurphy
 */
public class DingTalkSignAlgorithm implements SignAlgorithm<SignResult, Long> {
    public static final Logger logger = LoggerFactory.getLogger(DingTalkSignAlgorithm.class);
    private final String secret;
    private Mac mac;

    public DingTalkSignAlgorithm(String secret) throws InvalidKeyException, NoSuchAlgorithmException {
        this.secret = secret;
        init();
    }


    /**
     * 初始化签名工具
     */
    private void init() throws NoSuchAlgorithmException, InvalidKeyException {
        logger.debug("Initialize DingTalkSignAlgorithm. The secret is {}.", secret);
        mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
    }

    @Override
    public SignResult sign(Long timestamp) {
        String stringToSign = timestamp + "\n" + secret;
        byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
        try {
            return new SignResult(timestamp, URLEncoder.encode(new String(Base64.getEncoder().encode(signData)), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RobotException("不支持的编码类型", e);
        }
    }
}
