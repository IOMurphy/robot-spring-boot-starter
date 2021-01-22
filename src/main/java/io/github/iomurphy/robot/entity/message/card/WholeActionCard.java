package io.github.iomurphy.robot.entity.message.card;

import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class WholeActionCard extends ActionCard {
    private static final long serialVersionUID = 1L;

    /**
     * 单个按钮的标题。(设置此项和singleURL后btns无效)
     */
    private String singleTitle;
    /**
     * 点击singleTitle按钮触发的URL
     */
    private String singleURL;

    public WholeActionCard() {
        super(MsgTypeEnum.WHOLE_ACTION_CARD);
    }

    @Override
    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<>();
        map.put("msgtype", getMsgType());
        Map<String, Object> actionCard = new HashMap<>();
        actionCard.put("title", getTitle());
        actionCard.put("text", getText());
        actionCard.put("singleURL", singleURL);
        actionCard.put("singleTitle", singleTitle);
        actionCard.put("btnOrientation", getBtnOrientation().getOrientation());
        map.put("actionCard", actionCard);
        return map;
    }

    public String getSingleTitle() {
        return singleTitle;
    }

    public void setSingleTitle(String singleTitle) {
        this.singleTitle = singleTitle;
    }

    public String getSingleURL() {
        return singleURL;
    }

    public void setSingleURL(String singleURL) {
        this.singleURL = singleURL;
    }
}
