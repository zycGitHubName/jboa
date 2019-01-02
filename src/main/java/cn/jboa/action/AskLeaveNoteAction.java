package cn.jboa.action;

import cn.jboa.service.AskLeaveNoteService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 请假条：dao接口
 */
@Controller("askLeaveNoteAction")
public class AskLeaveNoteAction extends ActionSupport {

    @Autowired
    private AskLeaveNoteService askLeaveNoteService;
}
