package com.example.springbootweb.controller;

import com.example.springbootweb.model.SysOrg;
import com.example.springbootweb.model.User;
import com.example.springbootweb.service.SysOrgService;
import com.example.springbootweb.service.UserService;
import com.example.springbootweb.utils.LogUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Api swagger注解
 * @author liuhai
 * @date 2018-08-07 14:48
 * @description 用户管理控制器
 */
@RestController
@RequestMapping("/org")

public class OrgController {
    @Autowired
    private SysOrgService sysOrgService;

    /**
     * 查询用户信息
     * ResponseBody注解，测试API接口使用，正常运行时请删除该注解
     * RequestMapping 中 method = RequestMethod.GET 指定RequestMethod类型
     * @return
     */
    @RequestMapping(value = "/findChildOrgs", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @ApiOperation(value="获取子级组织", notes="组织ID必填")
    public Map<String,Object> findAll(@RequestBody String orgId){
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:MM:SSS");
        System.out.println("startTime:"+format.format(new Date()));
        SysOrg sysOrg = new SysOrg();
        sysOrg.setParentId(orgId);

        List<SysOrg> orgs = sysOrgService.findByParam(sysOrg);
        Map<String,Object> result = new HashMap<>();
        result.put("list",orgs);
        result.put("size",orgs.size());
        System.out.println("endTime:"+format.format(new Date()));
        return result;
    }







}
