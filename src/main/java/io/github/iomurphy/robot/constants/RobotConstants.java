package io.github.iomurphy.robot.constants;


/**
 * 机器人常量
 *
 * @author IOMurphy
 */
public class RobotConstants {
    /**
     * {
     *     "msgtype": "text",
     *     "text": {
     *         "content": "我就是我, 是不一样的烟火@156xxxx8827"
     *     },
     *     "at": {
     *         "atMobiles": [
     *             "156xxxx8827",
     *             "189xxxx8325"
     *         ],
     *         "isAtAll": false
     *     }
     * }
     */
    public static final String MSG_TYPE = "msgtype";
    public static final String CONTENT = "content";
    public static final String TEXT = "text";
    public static final String AT_MOBILES = "atMobiles";
    public static final String IS_AT_ALL = "isAtAll";
    public static final String AT = "at";

    /**
     * {
     *      "msgtype": "markdown",
     *      "markdown": {
     *          "title":"杭州天气",
     *          "text": "#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingtalk.com) \n"
     *      },
     *       "at": {
     *           "atMobiles": [
     *               "150XXXXXXXX"
     *           ],
     *           "isAtAll": false
     *       }
     *  }
     */

    public static final String MARKDOWN = "markdown";
    public static final String TITLE = "title";

    /**
     * {
     *     "msgtype": "link",
     *     "link": {
     *         "text": "这个即将发布的新版本，创始人xx称它为红树林。而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是红树林",
     *         "title": "时代的火车向前开",
     *         "picUrl": "",
     *         "messageUrl": "https://www.dingtalk.com/s?__biz=MzA4NjMwMTA2Ng==&mid=2650316842&idx=1&sn=60da3ea2b29f1dcc43a7c8e4a7c97a16&scene=2&srcid=09189AnRJEdIiWVaKltFzNTw&from=timeline&isappinstalled=0&key=&ascene=2&uin=&devicetype=android-23&version=26031933&nettype=WIFI"
     *     }
     * }
     */
    public static final String LINK = "link";
    public static final String PIC_URL = "picUrl";
    public static final String MESSAGE_URL = "messageUrl";


    /**
     * 属性分隔符
     */
    public static final String PROPERTIES_SEPARATOR = ".";

    /**
     * 属性prefix
     */
    public static final String PROPERTIES_PREFIX = "robot";

    /**
     * 钉钉属性prefix
     */
    public static final String DING_TALK_PROPERTIES_PREFIX = PROPERTIES_PREFIX + PROPERTIES_SEPARATOR + "dingtalk";


    /**
     * 线程池配置
     */
    public static final String ROBOT_THREAD_POOL_PROPERTIES_PREFIX = PROPERTIES_PREFIX + PROPERTIES_SEPARATOR + "thread-pool";

    /**
     * RestTemplate的bean名字
     */
    public static final String ROBOT_REST_TEMPLATE = "robotRestTemplate";
    /**
     * DingTalkTemplate的bean名字
     */
    public static final String DING_TALK_TEMPLATE = "dingTalkTemplate";
    /**
     * 线程池实例名字
     */
    public static final String EXECUTOR = "robot-executor";

    /**
     *
     */
    public static final String THREAD_PRE_FIX = "Robot-Thread";
}
