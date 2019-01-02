package cn.jboa.service.impl;

import cn.jboa.dao.SysEmployeeDao;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.service.SysEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 员工：Service实现
 */
@Service("sysEmployeeService")
public class SysEmployeeServiceImpl implements SysEmployeeService {

    @Autowired
    private SysEmployeeDao sysEmployeeDao;

    @Override
    public SysEmployee selectSysEmployeeBySn(String sn, String password) {
        try{
            SysEmployee employee = sysEmployeeDao.selectSysEmployeeBySn(sn);
            if (employee != null){
                if(employee.getPassword().equals(password)){
                    return employee;
                }
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
