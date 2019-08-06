package com.ming.ssm.service.impl;

import com.ming.ssm.dao.ISysLogDao;
import com.ming.ssm.domain.SysLog;
import com.ming.ssm.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "logService")
public class LogService implements ILogService{
    @Autowired
    public ISysLogDao iSysLogDao;

    public List<SysLog> findAll() throws Exception {
        return iSysLogDao.findAll();
    }
}
