package io.github.iomurphy.robot.entity.http;


/**
 * 请求Response
 *
 * @author IOmurphy
 */
public interface Response {

    int getErrCode();

    void setErrCode(int errCode);

    String getErrMsg();

    void setErrMsg(String errMsg);
}
