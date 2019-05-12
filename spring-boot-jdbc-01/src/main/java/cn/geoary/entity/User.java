package cn.geoary.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: spring-boot-jdbc-01
 * @description: 用户表
 * @author: Zhangc
 * @create: 2019-05-11 22:35
 **/
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String tel;

    public User() {

    }

    public User(String username, String tel) {
        this.username = username;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}

