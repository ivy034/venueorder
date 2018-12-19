package com.venue.venueorder.DO;

import lombok.Data;

import javax.persistence.*;

/**
 * @param: none
 * @description: 对应数据表的Venue类
 * @author: KingJ
 * @create: 2018-11-17 17:01
 **/
@Entity
@Data
@Table(name = "user")
public class Venue {

    /* ID */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    /* 场馆名 */
    @Column(name = "name")
    private String name;

    /* 场馆时间 */
    @Column(name = "time")
    private String time;

    /* 地点 */
    @Column(name = "address")
    private String address;

    /* 费用 */
    @Column(name = "cost")
    private Integer cost;

    public Venue(){
    }

    public Venue(String name){
        this.name = name;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
