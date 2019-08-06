package com.ming.ssm.service.impl;

import com.ming.ssm.dao.ISysLogDao;
import com.ming.ssm.domain.SysLog;
import com.ming.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysLogService implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }
}
