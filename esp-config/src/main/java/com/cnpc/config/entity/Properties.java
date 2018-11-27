package com.cnpc.config.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @Author 鬼王
 * @Date 2018/11/26 13:53
 */
@Data
@Entity
public class Properties implements Serializable {

    @Id
    @GeneratedValue(generator = "idStrategy")
    @GenericGenerator(name = "idStrategy", strategy = "uuid")
    private String id;

    private String application;

    private String profile;

    private String label;

    @Transient
    private List<KeyValue> values;
}
