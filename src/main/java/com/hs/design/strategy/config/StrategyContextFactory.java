package com.hs.design.strategy.config;

import com.hs.design.strategy.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author heshuai
 * @title: ContextFactory
 * @description: 工厂类，来管理所有的StrategyService实现类
 * @date 2021年03月14日 19:25
 */
@Component
public class StrategyContextFactory {
    // 别名管理类
    @Autowired
    private StrategyAlias strategyAlias;

    // 可以在这里直接注入IOC容器中的StrategyService相关实现，key为bean Id，value为Bean实例
    @Autowired
    private Map<String, StrategyService> strategyMap;
    // 通过BeanId来获取对应的策略实现
    public StrategyService getBy(String name) {
        return strategyMap.get(name);
    }

    public StrategyService getByAlias(String aliasName){
        String name = strategyAlias.of(aliasName);
        // 默认策略
        if (null == name){
            return strategyMap.get(StrategyAlias.DEFAULT_STRATEGY_NAME);
        }
        StrategyService strategy = strategyMap.get(name);
        if(null == strategy){
            strategy = strategyMap.get(StrategyAlias.DEFAULT_STRATEGY_NAME);
        }
        return strategy;
    }
}
