package org.thraex.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thraex.config.entity.Application;
import org.thraex.config.entity.Properties;
import org.thraex.config.service.ConfigService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 鬼王
 * @Date 2018/10/26 16:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private ConfigService configService;

    @Test
    public void findAll() {
        List<Application> list = configService.findAll();
        Map<String, List<Application>> collect1 = list.stream().collect(Collectors.groupingBy(Application::getName));
        Map<String, List<String>> collect = list.stream()
                .collect(Collectors.groupingBy(Application::getName,
                        Collectors.mapping(Application::getProfile,
                                Collectors.toList())));
        System.out.println(collect);
        Assert.assertEquals(0, list.size());
    }


    public static void main(String[] args) {
    }
}
