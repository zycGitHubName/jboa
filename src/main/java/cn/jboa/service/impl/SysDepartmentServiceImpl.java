package cn.jboa.service.impl;

import cn.jboa.dao.SysDepartmentDao;
import cn.jboa.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 部门：Service实现
 */
@Service("sysDepartmentService")
public class SysDepartmentServiceImpl implements SysDepartmentService {

    @Autowired
    private SysDepartmentDao sysDepartmentDao;
}
