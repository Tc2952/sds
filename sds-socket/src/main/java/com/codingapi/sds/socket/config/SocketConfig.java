package com.codingapi.sds.socket.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author lorne
 */
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "codingapi.sds.socket")
public class SocketConfig {


    /**
     * socket 心跳时间(秒)
     */
    private int heartTime;

    /**
     * 最大连接数
     */
    private int maxConnection;

    /**
     * nettyPort
     */
    private int nettyPort;

    /**
     * netty 端口号
     */
    private String nettyIp;

    /**
     * netty 的Tag
     */
    private String nettyTag;

    /**
     * Delivery的名称
     */
    private String deliveryName;


    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public int getNettyPort() {
        return nettyPort;
    }

    public void setNettyPort(int nettyPort) {
        this.nettyPort = nettyPort;
    }

    public String getNettyIp() {
        return nettyIp;
    }

    public void setNettyIp(String nettyIp) {
        this.nettyIp = nettyIp;
    }

    public String getNettyTag() {
        return nettyTag;
    }

    public void setNettyTag(String nettyTag) {
        this.nettyTag = nettyTag;
    }


    public int getHeartTime() {
        return heartTime;
    }

    public void setHeartTime(int heartTime) {
        this.heartTime = heartTime;
    }

    public int getMaxConnection() {
        return maxConnection;
    }

    public void setMaxConnection(int maxConnection) {
        this.maxConnection = maxConnection;
    }
}
