package cn.jboa.service;

import cn.jboa.pojo.BizClaimVoucher;
import cn.jboa.util.PageSupport;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 报销单：Service接口
 */
public interface BizClaimVoucherService {

    /**
     *
     * @param pageSupport
     * @param claimVoucher 查询条件：status，startDate，endDate
     * @return
     */
    /**
     * 根据条件分页查询保险单，
     * @param pageSupport 分页实体类对象
     * @param status 报销单状态
     * @param startDate 创建时间
     * @param endDate 结束时间
     * @param name 填报人或审批人
     * @return
     */
    public List<BizClaimVoucher> selectBizClaimVoucherByPageAndConditions(
            PageSupport<BizClaimVoucher> pageSupport,String positin,String name, String status, Timestamp startDate, Timestamp endDate);

    /**
     * 根据条件查询报销单总数量
     * @param status 报销单状态
     * @param startDate 创建时间
     * @param endDate 结束时间
     * @param name 填报人或审批人
     * @return
     */
    public int selectBizClaimVoucherCountByConditions(String positin,String name, String status, Timestamp startDate, Timestamp endDate);

    /**
     * 保存报销单
     * @param claimVoucher
     */
    public void insertBizClaimVoucher(BizClaimVoucher claimVoucher);

    /**
     * 根据报销单id查询报销单详细详细
     * @param id 报销单id
     * @return 报销单
     */
    public BizClaimVoucher selectBizClaimVoucherById(int id);
}
