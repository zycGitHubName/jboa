package cn.jboa.service.impl;

import cn.jboa.dao.BizClaimVoucherDao;
import cn.jboa.service.BizClaimVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 请假条：Service实现
 */
@Service("bizClaimVoucherService")
public class BizClaimVoucherServiceImpl implements BizClaimVoucherService {

    @Autowired
    private BizClaimVoucherDao bizClaimVoucherDao;

}
