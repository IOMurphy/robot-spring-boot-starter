package io.github.iomurphy.robot.entity.card;

import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IndependentActionCard extends ActionCard {
    private static final long serialVersionUID = 1L;


    /**
     * 按钮
     */
    private Queue<Button> buttons = new LinkedList<>();

    public IndependentActionCard() {
        super(MsgTypeEnum.INDEPENDENT_ACTION_CARD);
    }


    @Override
    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<>();
        map.put("msgtype", getMsgType());
        Map<String, Object> actionCard = new HashMap<>();
        actionCard.put("title", getTitle());
        actionCard.put("text", getText());
        actionCard.put("btnOrientation", getBtnOrientation().getOrientation());
        Queue<Map> btns = new LinkedList<>();
        for (Button button : buttons) {
            Map<String, String> btn = new HashMap<>(3);
            btn.put("title", button.getBtnTitle());
            btn.put("actionURL", button.getBtnActionUrl());
            btns.offer(btn);
        }
        actionCard.put("btns", btns);
        map.put("actionCard", actionCard);
        return map;
    }

    /**
     * 添加按钮
     *
     * @param button
     */
    public void addButton(Button button) {
        this.buttons.offer(button);
    }

    public Queue<Button> getButtons() {
        return this.buttons;
    }

    /**
     * 设置按钮集合
     *
     * @param buttons
     */
    public void setButtons(Queue<Button> buttons) {
        this.buttons = buttons;
    }
}
