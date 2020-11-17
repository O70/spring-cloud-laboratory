package org.thraex.config.service;

import org.thraex.config.entity.Application;
import org.thraex.config.entity.Properties;

import java.util.List;

/**
 * @Author 鬼王
 * @Date 2018/11/26 15:23
 */
public interface ConfigService {

    Application save(Application application);

    List<Application> save(List<Application> appList);

    void delete(String id);

    Application findById(String id);

    List<Application> findAll();

    @Deprecated
    List<Application> findByGroup();

    List<Properties> findByPid(String pid);

    Properties saveProperties(Properties properties);

    List<Properties> saveProperties(List<Properties> propList);

    void deleteProperties(String id);

}
