package com.example.springbootweb.controller;

import com.example.springbootweb.model.User;
import com.example.springbootweb.service.UserService;
import com.example.springbootweb.utils.LogUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Api swagger注解
 * @author liuhai
 * @date 2018-08-07 14:48
 * @description 用户管理控制器
 */
@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     * ResponseBody注解，测试API接口使用，正常运行时请删除该注解
     * RequestMapping 中 method = RequestMethod.GET 指定RequestMethod类型
     * @param user
     * @return
     */
    @RequestMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @ApiOperation(value="获取所有用户信息", notes="如果填写用户名、真实姓名，模糊匹配进行筛选数据")
    public Map<String,Object> findAll(@RequestBody User user){
        Map<String,Object> result = new HashMap<String,Object>();
        List<User> list = new ArrayList<>();
        String msg = "请填写用户名";
        int code = 0;
        if(null != user && user.getUserName() != null){
            msg = "";
            code = 1;
            list = userService.findAll(user);
        }

        Logger log = LogUtils.getExceptionLogger();
        Logger log1 = LogUtils.getBussinessLogger();
        Logger log2 = LogUtils.getDBLogger();
        log.error("getExceptionLogger===错误日志测试");
        log1.info("getBussinessLogger===业务日志测试");
        log2.debug("getDBLogger===数据库日志测试");

        result.put("list", list);
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    /**
     * 根据用户ID查询用户信息
     */
    @RequestMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @ApiOperation(value="根据用户ID查询用户信息", notes="用户ID必填")
    @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "userid", value = "用户ID", required = true)
    public Map<String,Object> findById(@RequestParam(value="userid") Integer userid){
        Map<String,Object> result = new HashMap<String,Object>();
        int code = 0;
        String msg = "用户ID无效，无对应的用户";
        User user = userService.findById(userid);
        if(null != user){
            code = 1;
            msg = "";
        }
        result.put("user", user);
        result.put("code", code);
        result.put("msg", msg);

        return result;
    }

    /**
     * 添加用户
     */
    @RequestMapping(value = "/add_user", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ApiOperation(value="添加用户", notes="用户名必填")
    public Map<String,Object> addUser(@RequestBody User user){
        Map<String,Object> result = new HashMap<String,Object>();
        int code = 0;
        String msg = "用户名必填";
        if(null != user && user.getUserName() != null){
            code = 1;
            msg = "";
            userService.insertSelective(user);
        }
        result.put("code", code);
        result.put("msg", msg);

        return result;
    }

    /**
     * 根据用户ID修改用户信息
     */
    @RequestMapping(value = "/upd_user", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ApiOperation(value="根据用户ID修改用户信息", notes="用户ID必填")
    public Map<String,Object> uptUser(@RequestBody User user){
        Map<String,Object> result = new HashMap<String,Object>();
        int code = 0;
        String msg = "用户ID必填";
        if(null != user && user.getUserid() != null){
            msg = "用户ID无效，无对应的用户";
            User uptUser = userService.findById(user.getUserid());
            if(null != uptUser){
                code = 1;
                msg = "";
                userService.updateSelective(user);
            }
        }
        result.put("code", code);
        result.put("msg", msg);

        return result;
    }

    /**
     * 根据用户ID删除用户信息
     */
    @RequestMapping(value = "/del_user", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ApiOperation(value="根据用户ID删除用户信息", notes="用户ID必填")
    @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "userid", value = "用户ID", required = true)
    public Map<String,Object> delUser(@RequestParam(value="userid") Integer userid){
        Map<String,Object> result = new HashMap<String,Object>();
        int code = 0;
        String msg = "用户ID必填";
        if(null != userid){
            msg = "用户ID无效，无对应的用户";
            User user = userService.findById(userid);
            if(null != user){
                code = 1;
                msg = "";
                userService.deleteById(userid);
            }
        }
        result.put("code", code);
        result.put("msg", msg);

        return result;
    }





}
