package com.codingapi.sds.delivery.service;

import com.codingapi.sds.delivery.model.Server;

import java.util.List;

/**
 * create by lorne on 2017/10/14
 */
public interface DeliveryServerService {


    Server getOkServer();

    List<Server> serverList();
}
