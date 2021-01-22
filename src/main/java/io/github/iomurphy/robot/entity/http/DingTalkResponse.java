package io.github.iomurphy.robot.entity.http;


/**
 * 钉钉消息Response
 *
 * @author IOmurphy
 */
public class DingTalkResponse implements Response {
    private static final long serialVersionUID = 1L;
    int errcode;
    String errmsg;

    public int getErrcode() {
        return getErrCode();
    }

    public void setErrcode(int errcode) {
        this.setErrCode(errcode);
    }

    public String getErrmsg() {
        return getErrMsg();
    }

    public void setErrmsg(String errmsg) {
        this.setErrMsg(errmsg);
    }

    @Override
    public int getErrCode() {
        return errcode;
    }

    @Override
    public void setErrCode(int errCode) {
        this.errcode = errCode;
    }

    @Override
    public String getErrMsg() {
        return errmsg;
    }

    @Override
    public void setErrMsg(String errMsg) {
        this.errmsg = errMsg;
    }

    @Override
    public String toString() {
        return "DingTalkResponse{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
