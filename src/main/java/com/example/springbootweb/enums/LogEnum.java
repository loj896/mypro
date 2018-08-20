package com.example.springbootweb.enums;

/**
 * @author liuhai
 * @date 2018-08-18 0:51
 * @description 本地日志枚举
 */
public enum LogEnum {
    //业务日志
    BUSSINESS("bussiness"),
    //运行日志
    PLATFORM("platform"),
    //数据库日志
    DB("db"),
    //错误日志
    EXCEPTION("exception"),
    ;


    private String category;


    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
