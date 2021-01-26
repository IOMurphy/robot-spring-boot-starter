package io.github.iomurphy.robot.entity.card;


import io.github.iomurphy.robot.entity.enums.MsgTypeEnum;
import io.github.iomurphy.robot.entity.message.AbstractMessage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FeedCard extends AbstractMessage {
    private static final long serialVersionUID = 1L;
    private Queue<Link> links = new LinkedList<>();

    public FeedCard() {
        super(MsgTypeEnum.FEED_CARD);
    }

    @Override
    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<>();
        map.put("msgtype", getMsgType());
        Map<String, Object> actionCard = new HashMap<>();
        Queue<Map> links = new LinkedList<>();
        for (Link link : this.links) {
            Map<String, String> btn = new HashMap<>(3);
            btn.put("title", link.getTitle());
            btn.put("messageURL", link.getMessageUrl());
            btn.put("picURL", link.getMessageUrl());
            links.offer(btn);
        }
        actionCard.put("links", links);
        map.put("feedCard", actionCard);
        return map;
    }

    /**
     * 获得链接
     *
     * @return
     */
    public Queue<Link> getLinks() {
        return links;
    }

    /**
     * 设置链接集合
     *
     * @param links
     */
    public void setLinks(Queue<Link> links) {
        this.links = links;
    }

    /**
     * 添加链接
     *
     * @param link
     */
    public void addLink(Link link) {
        this.links.offer(link);
    }
}
