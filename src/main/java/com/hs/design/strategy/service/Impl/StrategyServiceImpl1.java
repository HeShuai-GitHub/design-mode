package com.hs.design.strategy.service.Impl;

import com.hs.design.strategy.service.StrategyService;
import org.springframework.stereotype.Service;

/**
 * @author heshuai
 * @title: StrategyServiceImpl1
 * @description: TODO
 * @date 2021年03月14日 19:23
 */
@Service
public class StrategyServiceImpl1  implements StrategyService {
    @Override
    public void doSomething() {
        System.out.println("StrategyServiceImpl1 正在执行一些业务代码");
    }
}
