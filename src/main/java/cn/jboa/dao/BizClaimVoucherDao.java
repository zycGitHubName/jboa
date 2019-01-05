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
     * 根据条件分页查询保险单，
     * @param pageSupport 分页实体类对象
     * @param status 报销单状态
     * @param startDate 创建时间
     * @return 报销单集合
     */
    public List<BizClaimVoucher> selectBizClaimVoucherByPageAndConditions(
            PageSupport<BizClaimVoucher> pageSupport,String position,String name, String status, Timestamp startDate);

    /**
     * 根据条件查询报销单总数量
     * @param status 报销单状态
     * @param startDate 创建时间
     * @return 总条数
     */
    public int selectBizClaimVoucherCountByConditions(String position, String name, String status, Timestamp startDate, Timestamp endDate);

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
