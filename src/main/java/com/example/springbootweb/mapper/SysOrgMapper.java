package com.example.springbootweb.mapper;

import com.example.springbootweb.model.SysOrg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuhai
 * @date 2018-08-09 11:00
 * @description
 */
@Mapper
@Component(value = "SysOrgMapper")
public interface SysOrgMapper {

    List<SysOrg> findByParam(SysOrg sysOrg);
}
