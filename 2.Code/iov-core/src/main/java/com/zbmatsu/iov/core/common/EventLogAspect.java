package com.zbmatsu.iov.core.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;

import com.zbmatsu.iov.common.annotations.EventLog;
import com.zbmatsu.iov.common.web.ServiceContext;


//@Aspect //该注解标示该类为切面类 
//@Component //注入依赖
public class EventLogAspect {

	//标注该方法体为后置通知，当目标方法执行成功后执行该方法体  
    @AfterReturning(pointcut= "execution (* com.zbmatsu.iov.*.service.impl.*.*(..)) && @annotation(eventLog)", returning="returnValue")  
    public void addEventLog(JoinPoint point, EventLog recordEventLog, Object returnValue){  
    	
    	Object[] params = point.getArgs();
    	
    	for (Object object: params) {
			if(object.getClass() == ServiceContext.class){//service上下文
				
				ServiceContext serviceContext = (ServiceContext) object;
				System.out.println(serviceContext);
				//获取request  用于获取 oem
//				HttpServletRequest request = null;
//				try {
//					request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				HttpSession session = request.getSession();
				
				
				
			}
		}
    	
    	
    }  
  
    //标注该方法体为异常通知，当目标方法出现异常时，执行该方法体  
    @AfterThrowing(pointcut="execution (* com.zbmatsu.iov.*.service.impl.*.*(..)) && @annotation(eventLog)")  
    public void addLogException(JoinPoint point, EventLog recordEventLog){  
       System.out.println("EventLogAspect Exception......");
    }  
}
