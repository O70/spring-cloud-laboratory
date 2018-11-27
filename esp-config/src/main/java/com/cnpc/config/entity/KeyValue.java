package com.cnpc.config.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author 鬼王
 * @Date 2018/11/26 13:53
 */
@Data
@Entity
public class KeyValue implements Serializable {

    @Id
    @GeneratedValue(generator = "idStrategy")
    @GenericGenerator(name = "idStrategy", strategy = "uuid")
    private String id;

    private String pid;

    private String key;

    private String value;
}
