package cn.jboa.action;

import cn.jboa.service.SysDepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 部门：action
 */
@Controller("sysDepartmentAction")
public class SysDepartmentAction extends ActionSupport {

    @Autowired
    private SysDepartmentService sysDepartmentService;
}
