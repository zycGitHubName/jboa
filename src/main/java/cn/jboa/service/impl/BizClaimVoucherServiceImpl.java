package cn.jboa.service.impl;

import cn.jboa.dao.BizClaimVoucherDao;
import cn.jboa.pojo.BizCheckResult;
import cn.jboa.pojo.BizClaimVoucher;
import cn.jboa.service.BizClaimVoucherService;
import cn.jboa.util.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 请假条：Service实现
 */
@Service("bizClaimVoucherService")
public class BizClaimVoucherServiceImpl implements BizClaimVoucherService {

    @Autowired
    private BizClaimVoucherDao bizClaimVoucherDao;

    @Override
    public List<BizClaimVoucher> selectBizClaimVoucherByPageAndConditions(PageSupport<BizClaimVoucher> pageSupport, String createSn, String status, Timestamp startDate, Timestamp endDate) {
        try {
            List<BizClaimVoucher> claimVoucherList = bizClaimVoucherDao.selectBizClaimVoucherByPageAndConditions(pageSupport,createSn,status,startDate);
            if (endDate != null){
                for (int i = 0; i < claimVoucherList.size(); i++) {
                    Iterator<BizCheckResult> iterator = claimVoucherList.get(i).getBizCheckResultsById().iterator();
                    if(!iterator.hasNext()){
                        claimVoucherList.clear();
                        break;
                    }else if (!iterator.next().getCheckTime().before(endDate)){
                        claimVoucherList.remove(i);
                    }
                }
            }
            return claimVoucherList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int selectBizClaimVoucherCountByConditions(String createSn, String status, Timestamp startDate,Timestamp endDate) {
        try {
            int totalCount = bizClaimVoucherDao.selectBizClaimVoucherCountByConditions(createSn,status,startDate,endDate);
            return totalCount;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void insertBizClaimVoucher(BizClaimVoucher claimVoucher) {
        try {
            bizClaimVoucherDao.insertBizClaimVoucher(claimVoucher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
