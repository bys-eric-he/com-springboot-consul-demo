package com.service.app.controller;

import com.consul.model.response.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/app")
public class AppController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/name/{userId}", method = RequestMethod.GET)
    public CommonResult<String> queryName(@PathVariable(value = "userId") String userId) {
        return CommonResult.success("UserID:" + userId + "Service - B - Controller !!!", "请求成功, 处理服务端口：" + serverPort);
    }
}
