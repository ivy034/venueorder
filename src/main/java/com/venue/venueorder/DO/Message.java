package com.venue.venueorder.DO;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @param: none
 * @description: 对应数据表的Message类
 * @author: KingJ
 * @create: 2018-11-17 17:01
 **/
@Entity
@Data
@Table(name = "message")
public class Message {

    /* 新闻ID */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    /* 标题 */
    @Column(name = "title")
    public String title;

    /* 作者 */
    @Column(name = "author")
    public String author;

    /* 内容 */
    @Column(name = "content")
    public String content;

    /* 发布时间 */
    @Column(name = "announce_time")
    public Date announceTime;

    /*发布状态*/
    @Column(name="status")
    public String status;


    public Message(){
    }

    public Message(String title, String author){
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAnnounceTime() {
        return announceTime;
    }

    public void setAnnounceTime(Date announceTime) {
        this.announceTime = announceTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
