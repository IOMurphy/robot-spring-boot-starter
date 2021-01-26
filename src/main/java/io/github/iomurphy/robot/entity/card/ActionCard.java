package io.github.iomurphy.robot.entity.card;

import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;
import io.github.iomurphy.robot.entity.message.MarkdownMessage;


abstract class ActionCard extends MarkdownMessage {
    private static final long serialVersionUID = 1L;
    /**
     * 0-按钮竖直排列，1-按钮横向排列
     */
    private Button.BtnOrientation btnOrientation;


    public ActionCard(MsgTypeEnum msgTypeEnum) {
        super(msgTypeEnum);
    }

    public Button.BtnOrientation getBtnOrientation() {
        return btnOrientation;
    }

    public void setBtnOrientation(Button.BtnOrientation btnOrientation) {
        this.btnOrientation = btnOrientation;
    }
}
