package cn.jboa.service;

import cn.jboa.pojo.SysEmployee;

/**
 * 员工：Service接口
 */
public interface SysEmployeeService {

    /**
     * 根据员工登录名查询员工
     * @param sn
     * @return
     */
    public SysEmployee selectSysEmployeeBySn(String sn,String password);
}
