package org.thraex.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thraex.gateway.config.DefaultRibbonConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 鬼王
 * @date 2020/11/18 15:55
 */
@ConfigurationProperties("spring.cloud.gateway")
@Configuration
public class Test2 {

    @Value("${thraex.name}")
    private String name;

    private String name1;

    public Test2(@Value("${thraex.name}") String name1) {
        System.out.println(name);
        this.name1 = name1;
    }

    private List<RouteDefinition> routesXx = new ArrayList<>();

    public void setRoutesXx(List<RouteDefinition> routesXx) {
        this.routesXx = routesXx;
    }

    @Bean
    public DefaultRibbonConfig con() {
        return null;
    }


}
