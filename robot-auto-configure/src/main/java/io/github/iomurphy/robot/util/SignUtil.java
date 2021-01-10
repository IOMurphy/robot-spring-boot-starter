package io.github.iomurphy.robot.util;

import io.github.iomurphy.robot.except.RobotException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SignUtil {

    private String secret;
    private Mac mac;
    private static SignUtil instance;


    private SignUtil() {

    }

    public static SignUtil getInstance(String secret) throws InvalidKeyException, NoSuchAlgorithmException {
        if (instance == null) {
            synchronized (SignUtil.class) {
                if (instance == null) {
                    SignUtil signUtil = new SignUtil();
                    signUtil.init(secret);
                    instance = signUtil;
                }
            }
        }
        return instance;
    }

    /**
     * 初始化工具
     *
     * @param secret
     */
    private void init(String secret) throws NoSuchAlgorithmException, InvalidKeyException {
        if (this.secret != null && !this.secret.equals(secret)) {
            throw new RuntimeException("多次设置secret");
        }
        this.secret = secret;
        mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
    }

    public String sign(long timestamp) {
        String stringToSign = timestamp + "\n" + secret;
        byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
        try {
            return URLEncoder.encode(new String(Base64.getEncoder().encode(signData)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RobotException("不支持的编码类型", e);
        }
    }
}
