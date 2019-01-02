package cn.jboa.dao.impl;

import cn.jboa.dao.BizClaimVoucherDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 报销单：dao实现
 */
@Repository("bizClaimVoucherDao")
public class BizClaimVoucherDaoImpl extends HibernateDaoSupport implements BizClaimVoucherDao {

    @Autowired
    public BizClaimVoucherDaoImpl(@Qualifier(value = "sessionFactory") SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }
}
