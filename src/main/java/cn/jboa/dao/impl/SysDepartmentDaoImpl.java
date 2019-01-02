package cn.jboa.dao.impl;

import cn.jboa.dao.SysDepartmentDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 部门：dao实现
 */
@Repository("sysDepartmentDao")
public class SysDepartmentDaoImpl extends HibernateDaoSupport implements SysDepartmentDao {

    @Autowired
    public SysDepartmentDaoImpl(@Qualifier(value = "sessionFactory") SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }
}
