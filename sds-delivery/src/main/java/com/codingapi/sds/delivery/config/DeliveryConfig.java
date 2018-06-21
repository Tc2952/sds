package com.codingapi.sds.delivery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author lorne
 */
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "codingapi.sds.delivery")
public class DeliveryConfig {

    /**
     * socket port
     */
    private int port;

    /**
     * 扫码delivery检查时间（分钟）
     */
    private int checkTime;

    /**
     * Socket 模块名称
     */
    private String socketName;

    public String getSocketName() {
        return socketName;
    }

    public void setSocketName(String socketName) {
        this.socketName = socketName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(int checkTime) {
        this.checkTime = checkTime;
    }
}
