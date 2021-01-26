package io.github.iomurphy.robot.entity.card;


public class Button {
    private static final long serialVersionUID = 1L;
    /**
     * 按钮标题
     */
    private String btnTitle;
    /**
     * 点击按钮触发的URL
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

    /**
     * 按钮排列方向
     */
    public enum BtnOrientation {
        /**
         * 水平排列
         */
        HORIZONTAL(1),
        /**
         * 垂直排列
         */
        VERTICAL(0);
        /**
         * 按钮排列方向
         */
        private final int orientation;

        BtnOrientation(int orientation) {
            this.orientation = orientation;
        }

        public int getOrientation() {
            return this.orientation;
        }
    }
}
