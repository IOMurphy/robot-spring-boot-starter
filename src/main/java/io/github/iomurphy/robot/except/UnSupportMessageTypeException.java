package io.github.iomurphy.robot.except;

/**
 * 未支持的消息类型
 *
 * @author IOMurphy
 */
public class UnSupportMessageTypeException extends RobotException{
    public UnSupportMessageTypeException(String msg){
        super(msg);
    }
}
