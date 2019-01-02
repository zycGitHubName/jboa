package cn.jboa.dao;

import cn.jboa.pojo.SysEmployee;

/**
 * 员工：dao接口
 */
public interface SysEmployeeDao {

    /**
     * 根据员工登录名查询员工
     * @param sn
     * @return
     */
    public SysEmployee selectSysEmployeeBySn(String sn);

}
