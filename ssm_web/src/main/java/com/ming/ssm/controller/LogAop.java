package com.ming.ssm.controller;


import com.ming.ssm.domain.SysLog;
import com.ming.ssm.service.IRoleService;
import com.ming.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


@Controller
@Aspect
public class LogAop {
    @Autowired
    private ISysLogService sysLogService;


    @Autowired
    private HttpServletRequest request;
    private Date startTime; // 开始
    private Class aClass;
    private Method method;

    // 前置通知
    @Before("execution(* com.ming.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        startTime = new Date();
        aClass = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs(); // 获取访问的方法的参数

        if(args == null || args.length == 0){
            method = aClass.getMethod(methodName);
        }else{
            Class[] classArgs = new Class[args.length];
            for(int i = 0; i < args.length; i++){
                classArgs[i] = args[i].getClass();
            }
            aClass.getMethod(methodName, classArgs);
        }
    }

    @After("execution(* com.ming.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        long time = new Date().getTime() - this.startTime.getTime();

        String url = "";
       // if(aClass != null && method != null && aClass == LogAop.class){
            // 获取类上的
            RequestMapping classAnnotation = (RequestMapping)aClass.getAnnotation(RequestMapping.class);
            if(classAnnotation != null){
                String[] classValue = classAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation!= null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                }
            }
        //}

        // 获取request
        String ip = request.getRemoteAddr();

        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        SysLog sysLog = new SysLog();
        sysLog.setVisitTime(time);
        sysLog.setIp(ip);
        sysLog.setMethod("[类名]" + aClass.getName() + "[方法名]" + method.getName());
        sysLog.setUrl(url);
        sysLog.setUsername(username);

        sysLogService.save(sysLog);

    }
}
