package cn.geoary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: java-run-bat
 * @description: 定时任务库表
 * @author: Zhangc
 * @create: 2019-06-02 20:44
 **/
@Entity
public class Corn {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String cron;

    public Corn() {

    }

    public Corn(Integer id, String cron) {
        this.id = id;
        this.cron = cron;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public String toString() {
        return "Corn{" +
                "id=" + id +
                ", cron='" + cron + '\'' +
                '}';
    }
}

