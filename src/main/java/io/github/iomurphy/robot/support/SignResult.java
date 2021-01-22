package io.github.iomurphy.robot.support;


/**
 * 签名结果类
 *
 * @author IOMurphy
 */
public class SignResult {
    private final long timestamp;
    private final String signature;

    public SignResult(long timestamp, String signature) {
        this.timestamp = timestamp;
        this.signature = signature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSignature() {
        return signature;
    }
}
