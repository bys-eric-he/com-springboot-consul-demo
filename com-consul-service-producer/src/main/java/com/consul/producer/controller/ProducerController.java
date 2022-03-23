package com.consul.producer.controller;

import com.consul.model.RequestParamModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api/producer")
public class ProducerController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String queryUser(@RequestBody RequestParamModel request) {
        log.info("-----------Producer Service 请求到达-------------");
        return "端口:" + serverPort + " hello, " + request.getUserName() + "！";
    }
}
