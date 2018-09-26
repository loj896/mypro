package com.example.springbootweb.service.imp;

import com.example.springbootweb.mapper.SysOrgMapper;
import com.example.springbootweb.model.SysOrg;
import com.example.springbootweb.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrgServiceImp implements SysOrgService {

    @Autowired
    private SysOrgMapper sysOrgMapper;

    @Override
    public List<SysOrg> findByParam(SysOrg sysOrg) {
        List<SysOrg> list = sysOrgMapper.findByParam(sysOrg);

        list = this.findChildSysOrgs(list);
        return list;
    }

    public List<SysOrg> findChildSysOrgs(List<SysOrg> list){
        SysOrg param = null;
        for(int i =0; i<list.size(); i++){
            if(null != list.get(i).getParentId()){
                param = new SysOrg();
                param.setParentId(list.get(i).getOrgId());
                this.queryChildSysOrgs(list,param);
            }
        }
        return list;
    }

    public List<SysOrg> queryChildSysOrgs(List<SysOrg> list,SysOrg sysOrg){
        List<SysOrg> tmpList = sysOrgMapper.findByParam(sysOrg);
        SysOrg param = null;
        for(int i =0; i<tmpList.size(); i++){
            list.add(tmpList.get(i));
            if(null != tmpList.get(i).getParentId()){
                param = new SysOrg();
                param.setParentId(tmpList.get(i).getOrgId());
                this.queryChildSysOrgs(list,param);
            }
        }
        return list;
    }
}
