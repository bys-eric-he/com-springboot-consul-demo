package com.service.app.controller;

import com.consul.facade.ProduceServiceRemote;
import com.consul.model.RequestParamModel;
import com.consul.model.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/app")
public class AppController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private ProduceServiceRemote produceServiceRemote;

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public CommonResult<String> queryUser(@RequestBody RequestParamModel request) {
        return CommonResult.success(produceServiceRemote.queryUser(request), "请求成功, 处理服务端口：" + serverPort);
    }

    @RequestMapping(value = "/name/{userId}", method = RequestMethod.GET)
    public CommonResult<String> queryName(@PathVariable(value = "userId") String userId) {
        return CommonResult.success("UserID:" + userId + "Service - A - Controller !!!", "请求成功, 处理服务端口：" + serverPort);
    }
}
