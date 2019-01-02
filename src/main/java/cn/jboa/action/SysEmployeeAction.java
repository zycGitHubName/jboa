package cn.jboa.action;

import cn.jboa.service.SysEmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 员工：action
 */
@Controller("sysEmployeeAction")
public class SysEmployeeAction extends ActionSupport {

    @Autowired
    private SysEmployeeService sysEmployeeService;

}
