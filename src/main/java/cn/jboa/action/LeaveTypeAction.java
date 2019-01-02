package cn.jboa.action;

import cn.jboa.service.LeaveTypeService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 休假类型：action
 */
@Controller("leaveTypeAction")
public class LeaveTypeAction extends ActionSupport {

    @Autowired
    private LeaveTypeService leaveTypeService;
}
