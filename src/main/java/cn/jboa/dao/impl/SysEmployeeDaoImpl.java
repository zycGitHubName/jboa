package cn.jboa.dao.impl;

import cn.jboa.dao.SysEmployeeDao;
import cn.jboa.pojo.SysEmployee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 员工：dao实现
 */
@Repository("sysEmployeeDao")
public class SysEmployeeDaoImpl extends HibernateDaoSupport implements SysEmployeeDao {

    @Autowired
    public SysEmployeeDaoImpl(@Qualifier(value = "sessionFactory") SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }


    @Override
    public SysEmployee selectSysEmployeeBySn(String sn) {
        return (SysEmployee) this.getHibernateTemplate().find("from SysEmployee where sn = ?",sn).get(0);
    }
}
