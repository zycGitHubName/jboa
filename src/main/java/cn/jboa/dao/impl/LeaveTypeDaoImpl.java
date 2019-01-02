package cn.jboa.dao.impl;

import cn.jboa.dao.LeaveTypeDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 休假类型：dao实现
 */
@Repository("leaveTypeDao")
public class LeaveTypeDaoImpl extends HibernateDaoSupport implements LeaveTypeDao {

    @Autowired
    public LeaveTypeDaoImpl(@Qualifier(value = "sessionFactory") SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }
}
