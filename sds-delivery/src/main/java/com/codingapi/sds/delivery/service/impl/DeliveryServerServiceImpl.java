package com.codingapi.sds.delivery.service.impl;

import com.codingapi.sds.delivery.config.DeliveryConfig;
import com.codingapi.sds.delivery.service.DeliveryServerService;
import com.codingapi.sds.delivery.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * create by lorne on 2017/10/14
 */
@Service
public class DeliveryServerServiceImpl implements DeliveryServerService {



    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeliveryConfig deliveryConfig;


    @Override
    public Server getOkServer() {

        List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(deliveryConfig.getSocketName());

        //选取socket服务
        if (serviceInstances != null && serviceInstances.size() > 0 ) {
            for(ServiceInstance instance : serviceInstances){
                URI uri = instance.getUri();
                if (uri !=null ) {
                    Server server =  restTemplate.getForObject(uri+"/socket/getServer",Server.class);
                    if(server.getNowCount()<=server.getMaxCount()){
                        return server;
                    }
                }
            }
        }

        return null;
    }


    @Override
    public List<Server> serverList() {
        List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(deliveryConfig.getSocketName());

        List<Server> servers = new ArrayList<>();

        //选取socket服务
        if (serviceInstances != null && serviceInstances.size() > 0 ) {
            for(ServiceInstance instance : serviceInstances){
                URI uri = instance.getUri();
                if (uri !=null ) {
                    Server server =  restTemplate.getForObject(uri+"/socket/getServer",Server.class);
                    servers.add(server);
                }
            }
        }

        return servers;
    }
}
