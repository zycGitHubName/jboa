package cn.jboa.filter;

import cn.jboa.common.CommonProperties;
import cn.jboa.pojo.SysEmployee;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class LoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map session = actionInvocation.getInvocationContext().getSession();
        SysEmployee employee = (SysEmployee) session.get(CommonProperties.CURRERNT_EMP);
        if (employee == null){
            return Action.LOGIN;
        }else{
            return actionInvocation.invoke();
        }
    }
}
