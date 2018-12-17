package com.venue.venueorder.DO;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * @param: none
 * @description: 对应数据表的User类
 * @author: KingJ
 * @create: 2018-11-17 17:01
 **/
@Entity//声明了这是一个实体，可以被扫描到
@Data//get set生成
@Table(name = "user")//和数据库中user表映射

public class User {

    /* 用户ID */
    @Id//id为主键
    @GeneratedValue//自增id？
    @Column(name = "id")//对应数据库的字段为id（列名）
    private Integer id;

    /* 用户名 */
    @Column(name = "name")
    private String name;

    /* 用户密码 */
    @Column(name = "password")
    private String password;

    /* 手机号 */
    @Column(name = "phoneNumber")
    private String phoneNumber;

    /* 邮箱 */
    @Column(name = "email")
    private String email;

    @Column(name = "sex")
    private  String sex;

    public User(){
    }

//    public User(String name, String password){
//        this.name = name;
//        this.password = password;
//    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

