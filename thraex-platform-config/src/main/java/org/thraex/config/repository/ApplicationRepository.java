package org.thraex.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thraex.config.entity.Application;

/**
 * @Author 鬼王
 * @Date 2018/11/26 13:47
 */
public interface ApplicationRepository extends JpaRepository<Application, String> {
}
