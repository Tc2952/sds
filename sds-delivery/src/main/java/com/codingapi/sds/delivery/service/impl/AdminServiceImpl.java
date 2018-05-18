package com.codingapi.sds.delivery.service.impl;

import com.codingapi.sds.delivery.ato.vo.ModelNode;
import com.codingapi.sds.delivery.ato.vo.ResModel;
import com.codingapi.sds.delivery.service.AdminService;
import com.codingapi.sds.delivery.service.RedisService;
import com.codingapi.sds.delivery.service.SettingService;
import com.codingapi.sds.delivery.model.DeliveryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * create by lorne on 2017/12/6
 */
@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private RedisService redisService;

    @Autowired
    private SettingService settingService;


    @Override
    public ResModel view() {
        List<String> models =  redisService.models();
        if(models!=null){
            Collections.reverse(models);
        }

        ResModel resModel = new ResModel();
        for(String m:models){
            String modelName = m.replace(RedisService.sds_prefix,"");
            resModel.getNodes().add(new ModelNode(modelName,redisService.all(modelName).size()));
        }
        return resModel;
    }

    @Override
    public List<String> models() {
        List<String> models =  redisService.models();
        if(models!=null){
            Collections.reverse(models);
        }

        List<String> newModels = new ArrayList<>();
        for(String m:models){
            newModels.add(m.replace(RedisService.sds_prefix,""));
        }
        return newModels;
    }

    @Override
    public List<String> connections(String key) {
        List<String> connections = new ArrayList<>(redisService.all(key));
        if(connections!=null){
            Collections.reverse(connections);
        }
        return connections;
    }


    @Override
    public DeliveryModel getSetting() {
        return settingService.loadSetting();
    }
}
