package com.codingapi.sds.delivery.service;

import com.codingapi.sds.delivery.ato.vo.ResModel;
import com.codingapi.sds.delivery.model.DeliveryModel;

import java.util.List;

/**
 * create by lorne on 2017/12/6
 */
public interface AdminService {

    List<String> models();

    ResModel view();

    List<String> connections(String key);

    DeliveryModel getSetting();

}
