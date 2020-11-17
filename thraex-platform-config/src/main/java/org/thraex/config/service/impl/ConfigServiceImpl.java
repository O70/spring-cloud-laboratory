package org.thraex.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.thraex.config.entity.Application;
import org.thraex.config.entity.Properties;
import org.thraex.config.repository.ApplicationRepository;
import org.thraex.config.repository.PropertiesRepository;
import org.thraex.config.service.ConfigService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 鬼王
 * @Date 2018/11/26 15:24
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private PropertiesRepository propertiesRepository;

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> save(List<Application> appList) {
        return applicationRepository.saveAll(appList);
    }

    @Override
    @Transactional
    public void delete(String id) {
        applicationRepository.deleteById(id);
        propertiesRepository.deleteByPid(id);
    }

    @Override
    public Application findById(String id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll(Sort.by("name", "profile", "label"));
    }

    @Override
    public List<Application> findByGroup() {
        Map<String, List<Application>> collect = this.findAll().stream().collect(
                Collectors.groupingBy(it -> it.getName() + "/" + it.getProfile() + "/" + it.getLabel()));
        List<Application> result = new ArrayList<>();
        collect.forEach((k, v) -> {
            String[] split = k.split("/");
            Application p = new Application();
            p.setId(k);
            p.setName(split[0]);
            p.setProfile(split[1]);
            p.setLabel(split[2]);
            result.add(p);
        });

        return result.stream().sorted(Comparator.comparing(Application::getName)
                .thenComparing(Application::getProfile).thenComparing(Application::getLabel))
                .collect(Collectors.toList());
    }

    @Override
    public List<Properties> findByPid(String pid) {
        return propertiesRepository.findByPidOrderByAttributeAscValueAsc(pid);
    }

    @Override
    public Properties saveProperties(Properties properties) {
        return propertiesRepository.save(properties);
    }

    @Override
    public List<Properties> saveProperties(List<Properties> propList) {
        return propertiesRepository.saveAll(propList);
    }

    @Override
    public void deleteProperties(String id) {
        propertiesRepository.deleteById(id);
    }

}
