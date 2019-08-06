package com.ming.ssm.service;

import com.ming.ssm.domain.SysLog;

import java.util.List;

public interface ILogService {
    public List<SysLog> findAll()throws Exception;
}
