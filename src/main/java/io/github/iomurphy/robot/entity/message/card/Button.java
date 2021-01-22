package io.github.iomurphy.robot.entity.message.card;


public class Button {
    private static final long serialVersionUID = 1L;
    /**
     * 按钮标题
     */
    private String btnTitle;
    /**
     * 按钮触发的url
     */
    private String btnActionUrl;
    public Button(String btnTitle, String btnActionUrl) {
        this.btnTitle = btnTitle;
        this.btnActionUrl = btnActionUrl;
    }

    public String getBtnTitle() {
        return btnTitle;
    }

    public void setBtnTitle(String btnTitle) {
        this.btnTitle = btnTitle;
    }

    public String getBtnActionUrl() {
        return btnActionUrl;
    }

    public void setBtnActionUrl(String btnActionUrl) {
        this.btnActionUrl = btnActionUrl;
    }

    public enum BtnOrientation {
        HORIZONTAL(1), VERTICAL(0);
        private final int orientation;

        BtnOrientation(int orientation) {
            this.orientation = orientation;
        }

        public int getOrientation() {
            return this.orientation;
        }
    }
}
