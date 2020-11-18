package org.thraex.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 鬼王
 * @date 2020/11/18 15:49
 */
@RestController
@RequestMapping("test")
public class Test {

    @Value("${thraex.name}")
    private String name;

    public Test(@Value("${thraex.name}") String name1) {
        System.out.println(name);
    }

    @GetMapping
    public String test() {
        return name;
    }

}
