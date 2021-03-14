package com.hs.design.strategy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author heshuai
 * @title: StrategyAlias
 * @description: 定义别名，使实际项目中，业务名称和Bean Id相对应
 * @date 2021年03月14日 19:31
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "strategy")
public class StrategyAlias {

    private Map<String,String> aliasMap;

    public static String DEFAULT_STRATEGY_NAME = "strategyServiceDefault";

    public void setAliasMap(Map<String, String> aliasMap) {
        this.aliasMap = aliasMap;
    }

    public String of(String strategyName){
        return this.aliasMap.get(strategyName);
    }
}
