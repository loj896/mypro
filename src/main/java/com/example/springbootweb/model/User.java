package com.example.springbootweb.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author liuhai
 * @date 2018-08-07 14:14
 * @description 用户对象模型
 */
//@ApiModel(value="用户对象模型")
// 对象必须实现序列化，才能存储到Redis。如果没实现Serializable，控制台会报DefaultSerializer requires a Serializable payload but received an object of type异常
public class User implements Serializable {
    private Integer userid;

    @ApiModelProperty(value="用户名" ,required=true)
    private String userName;

    private String password;

    @ApiModelProperty(value="真实姓名" ,required=true)
    private String realName;

    public Integer getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
