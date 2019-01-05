package cn.jboa.dao;

import cn.jboa.pojo.BizClaimVoucher;
import cn.jboa.util.PageSupport;

import java.sql.Timestamp;
import java.util.List;

/**
 * 报销单：dao接口
 */
public interface BizClaimVoucherDao {

    /**
     *
     * @param pageSupport
     * @param claimVoucher 查询条件：status，startDate
     * @return
     */
    /**
     * 根据条件分页查询保险单，
     * @param pageSupport 分页实体类对象
     * @param status 报销单状态
     * @param startDate 创建时间
     * @return
     */
    public List<BizClaimVoucher> selectBizClaimVoucherByPageAndConditions(
            PageSupport<BizClaimVoucher> pageSupport,String createSn, String status, Timestamp startDate);

    /**
     * 根据条件查询报销单总数量
     * @param status 报销单状态
     * @param startDate 创建时间
     * @return
     */
    public int selectBizClaimVoucherCountByConditions(String createSn, String status, Timestamp startDate, Timestamp endDate);

    /**
     * 保存报销单
     * @param claimVoucher
     */
    public void insertBizClaimVoucher(BizClaimVoucher claimVoucher);

}
