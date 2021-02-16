package com.bee.mall.gateway.controller;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * description: sentinel客户端暴露接口 <br>
 * date: 2021/2/13 12:05 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@Api()
@RestController
public class RulesController {

    /**
     * api监控接口
     * @return 返回监控的接口
     */
    @GetMapping("/api")
    @SentinelResource("api")
    public Set<ApiDefinition> apiRules() {
        return GatewayApiDefinitionManager.getApiDefinitions();
    }

    /**
     * 路由规则
     * @return 返回路由规则
     */
    @GetMapping("/gateway")
    @SentinelResource("gateway")
    public Set<GatewayFlowRule> apiGateway() {
        return GatewayRuleManager.getRules();
    }

    /**
     * 加载规则
     * @return 返回加载规则
     */
    @GetMapping("/flow")
    @SentinelResource("flow")
    public List<FlowRule> apiFlow() {
        return FlowRuleManager.getRules();
    }
}
