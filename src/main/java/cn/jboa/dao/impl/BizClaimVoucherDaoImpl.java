package cn.jboa.dao.impl;

import cn.jboa.dao.BizClaimVoucherDao;
import cn.jboa.pojo.BizClaimVoucher;
import cn.jboa.util.PageSupport;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 报销单：dao实现
 */
@Repository("bizClaimVoucherDao")
public class BizClaimVoucherDaoImpl extends HibernateDaoSupport implements BizClaimVoucherDao {

    @Autowired
    public BizClaimVoucherDaoImpl(@Qualifier(value = "sessionFactory") SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }


    @Override
    public List<BizClaimVoucher> selectBizClaimVoucherByPageAndConditions(PageSupport<BizClaimVoucher> pageSupport,String createSn, String status, Timestamp startDate) {
        return this.getHibernateTemplate().executeFind(new HibernateCallback(){
            @Override
            public List<BizClaimVoucher> doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer hql = new StringBuffer("from BizClaimVoucher bcv where 1 = 1 and bcv.sysEmployeeByCreateSn.name = :createSn" );
                if(status != null && !"-1".equals(status)){
                    hql.append(" and bcv.status = :status");
                }
                if(startDate != null){
                    hql.append(" and bcv.createTime > :startDate ");
                }

                Query query = session.createQuery(hql.toString());
                query.setParameter("createSn",createSn);
                if(status != null  && !"-1".equals(status)){
                    query.setParameter("status",status);
                }
                if(startDate != null){
                    query.setParameter("startDate",startDate);
                }



                return query
                        .setFirstResult((pageSupport.getCurrPageNo()-1)*pageSupport.getPageSize())
                        .setMaxResults(pageSupport.getPageSize()).list();
            }
        });
    }

    @Override
    public int selectBizClaimVoucherCountByConditions(String createSn,String status, Timestamp startDate,Timestamp endDate) {
        List<String> paramNames = new ArrayList<String>();
        List<Object> values = new ArrayList<Object>();
        StringBuffer hql = new StringBuffer("select count(bcv.id) from BizClaimVoucher bcv" );
        if (endDate != null){
            hql.append(",BizCheckResult bcr where bcr.bizClaimVoucherByClaimId.id = bcv.id and bcv.sysEmployeeByCreateSn.name = :createSn");
        }else{
            hql.append(" where 1 = 1 and bcv.sysEmployeeByCreateSn.name = :createSn");
        }
        paramNames.add("createSn");
        values.add(createSn);
        if(status != null && !"".equals(status)){
            hql.append(" and bcv.status = :status");
            paramNames.add("status");
            values.add(status);
        }
        if(startDate != null){
            hql.append(" and bcv.createTime > :createTime ");
            paramNames.add("createTime");
            values.add(startDate);
        }
        if(endDate != null){
            hql.append(" and bcr.checkTime < :endDate ");
            paramNames.add("endDate");
            values.add(endDate);
        }
        String[] objects = new String[0];
        Object result = null;
        if(paramNames.size() != 0) {
            objects = paramNames.toArray(new String[paramNames.size()]);
            result = this.getHibernateTemplate().findByNamedParam(hql.toString(), objects, values.toArray()).listIterator().next();
        }else{
            System.out.println(result);
            result = this.getHibernateTemplate().find(hql.toString()).listIterator().next();
        }

        if (result.toString().length() != 0){
            return Integer.parseInt(result.toString());
        }
        return 0;
    }

    @Override
    public void insertBizClaimVoucher(BizClaimVoucher claimVoucher) {
        this.getHibernateTemplate().save(claimVoucher);
    }
}
