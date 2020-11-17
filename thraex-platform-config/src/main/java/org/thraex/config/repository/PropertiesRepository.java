package org.thraex.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thraex.config.entity.Properties;

import java.util.List;

/**
 * @Author 鬼王
 * @Date 2018/11/27 14:32
 */
public interface PropertiesRepository extends JpaRepository<Properties, String> {

    List<Properties> findByPidOrderByAttributeAscValueAsc(String pid);

    void deleteByPid(String pid);

}
