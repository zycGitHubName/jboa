package cn.jboa.service.impl;

import cn.jboa.dao.LeaveTypeDao;
import cn.jboa.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 休假类型：Service实现
 */
@Service("leaveTypeService")
public class LeaveTypeServiceImpl implements LeaveTypeService {

    @Autowired
    private LeaveTypeDao leaveTypeDao;

}
