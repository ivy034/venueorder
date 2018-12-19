package com.venue.venueorder.DO;

import lombok.Data;

import javax.persistence.*;

/**
 * @param: none
 * @description: 对应数据表的Manager类
 * @author: KingJ
 * @create: 2018-11-17 17:01
 **/
@Entity
@Data
@Table(name = "manager")
public class Manager {

    /* 用户ID */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    /* 用户名 */
    @Column(name = "name")
    private String name;

    /* 用户密码 */
    @Column(name = "password")
    private String password;


    public Manager(){
    }

    public Manager(String name, String password){
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
