package com.venue.venueorder.DO;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @param: none
 * @description: 对应数据表的Order类
 * @author: KingJ
 * @create: 2018-11-17 17:01
 **/
@Entity
@Data
@Table(name = "order")
public class Order {

    /* 订单ID */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    /* 用户ID */
    @Column(name = "user_id")
    private Integer userId;

    /* 场馆ID */
    @Column(name = "venue_id")
    private Integer venueId;

    /* 场馆时间 */
    @Column(name = "venue_time")
    private  String venueTime;

    /*场馆名称*/
    @Column(name ="venue_name")
    private  String venueName;

    /* 费用 */
    @Column(name = "cost")
    private int cost;

    /* 创建时间 */
    @Column(name = "create_time")
    private Date createTime;

    /*当前状态*/
    @Column(name = "status")
    private String status;

    public Order(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueTime() {
        return venueTime;
    }

    public void setVenueTime(String venueTime) {
        this.venueTime = venueTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
}
