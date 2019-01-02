package cn.jboa.action;

import cn.jboa.service.BizClaimVoucherService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 报销单：action
 */
@Controller("bizClaimVoucherAction")
public class BizClaimVoucherAction extends ActionSupport {

    @Autowired
    private BizClaimVoucherService bizClaimVoucherService;
}
