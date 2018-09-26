package com.example.springbootweb.service;

import com.example.springbootweb.model.SysOrg;

import java.util.List;

public interface SysOrgService {

    /**
     * 查询组织结构
     * @param sysOrg
     * @return
     */
    List<SysOrg> findByParam(SysOrg sysOrg);
}
