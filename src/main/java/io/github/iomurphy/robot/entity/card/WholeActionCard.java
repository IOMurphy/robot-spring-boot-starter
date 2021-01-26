package io.github.iomurphy.robot.entity.card;

import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class WholeActionCard extends ActionCard {
    private static final long serialVersionUID = 1L;

    /**
     * 单个按钮的标题
     */
    private String singleTitle;
    /**
     * 单个按钮的跳转链接
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
