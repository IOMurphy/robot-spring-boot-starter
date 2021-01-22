package io.github.iomurphy.robot.except;


/**
 * 机器人异常
 *
 * @author IOMurphy
 */
public class RobotException extends RuntimeException {

    public RobotException() {
        super();
    }

    public RobotException(String msg) {
        super(msg);
    }

    public RobotException(String message, Throwable cause) {
        super(message, cause);
    }

    public RobotException(Throwable cause) {
        super(cause);
    }

    protected RobotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
