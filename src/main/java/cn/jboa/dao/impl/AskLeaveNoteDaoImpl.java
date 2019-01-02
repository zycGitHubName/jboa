package cn.jboa.dao.impl;

import cn.jboa.dao.AskLeaveNoteDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 请假条：dao实现
 */
@Repository("askLeaveNoteDao")
public class AskLeaveNoteDaoImpl extends HibernateDaoSupport implements AskLeaveNoteDao {

    @Autowired
    public AskLeaveNoteDaoImpl(@Qualifier(value = "sessionFactory") SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }

}
