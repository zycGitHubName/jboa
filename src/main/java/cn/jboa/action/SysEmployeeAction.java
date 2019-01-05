package cn.jboa.action;

import cn.jboa.common.CommonProperties;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.service.SysEmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * 员工：action
 */
@Controller("sysEmployeeAction")
public class SysEmployeeAction extends ActionSupport {

    @Autowired
    private SysEmployeeService sysEmployeeService;

    /**
     * 登录的员工
     */
    private SysEmployee employee;

    /**
     * 登录失败的提示消息
     */
    private String msg;

    /**
     * 登录的验证码
     */
    private String random;

    /**
     * 登录的方法
     * @return
     */
    public String login(){
        Map session = ActionContext.getContext().getSession();
        if (session.get(CommonProperties.CHECKCODE).toString().equals(random)){
            employee = sysEmployeeService.selectSysEmployeeBySn(employee.getSn(),employee.getPassword());
            if (employee != null){
                session.put(CommonProperties.CURRERNT_EMP,employee);
                session.put(CommonProperties.CURRENT_EMP_POSITION,employee.getStatus());
                return SUCCESS;
            }
            this.setMsg("用户名或密码错误！");
            return LOGIN;
        }
        this.setMsg("验证码错误");
        return LOGIN;
    }



    public SysEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(SysEmployee employee) {
        this.employee = employee;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }
}
