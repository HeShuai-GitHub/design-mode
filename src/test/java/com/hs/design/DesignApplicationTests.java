package com.hs.design;

import com.hs.design.strategy.config.StrategyContextFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignApplicationTests {

    @Autowired
    private StrategyContextFactory strategyContextFactory;

    @Test
    void testStrategy(){
        strategyContextFactory.getBy("strategyServiceImpl1").doSomething();
        strategyContextFactory.getBy("strategyServiceImpl2").doSomething();
        strategyContextFactory.getBy("strategyServiceDefault").doSomething();
    }

    @Test
    void testStrategyAlias(){
        strategyContextFactory.getByAlias("strategy1").doSomething();
        strategyContextFactory.getByAlias("strategy2").doSomething();
        strategyContextFactory.getByAlias("notExist").doSomething();
    }

}
