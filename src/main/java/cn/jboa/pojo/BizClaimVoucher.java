package cn.jboa.pojo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * 报销单实体类
 */
public class BizClaimVoucher {
    private int id;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private String event;
    private Double totalAccount;
    private String status;
    private Collection<BizCheckResult> bizCheckResultsById;
    private SysEmployee sysEmployeeByNextDealSn;
    private SysEmployee sysEmployeeByCreateSn;
    private Collection<BizClaimVoucherDetail> bizClaimVoucherDetailsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Double getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(Double totalAccount) {
        this.totalAccount = totalAccount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BizClaimVoucher that = (BizClaimVoucher) o;
        return id == that.id &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(modifyTime, that.modifyTime) &&
                Objects.equals(event, that.event) &&
                Objects.equals(totalAccount, that.totalAccount) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, modifyTime, event, totalAccount, status);
    }

    public Collection<BizCheckResult> getBizCheckResultsById() {
        return bizCheckResultsById;
    }

    public void setBizCheckResultsById(Collection<BizCheckResult> bizCheckResultsById) {
        this.bizCheckResultsById = bizCheckResultsById;
    }

    public SysEmployee getSysEmployeeByNextDealSn() {
        return sysEmployeeByNextDealSn;
    }

    public void setSysEmployeeByNextDealSn(SysEmployee sysEmployeeByNextDealSn) {
        this.sysEmployeeByNextDealSn = sysEmployeeByNextDealSn;
    }

    public SysEmployee getSysEmployeeByCreateSn() {
        return sysEmployeeByCreateSn;
    }

    public void setSysEmployeeByCreateSn(SysEmployee sysEmployeeByCreateSn) {
        this.sysEmployeeByCreateSn = sysEmployeeByCreateSn;
    }

    public Collection<BizClaimVoucherDetail> getBizClaimVoucherDetailsById() {
        return bizClaimVoucherDetailsById;
    }

    public void setBizClaimVoucherDetailsById(Collection<BizClaimVoucherDetail> bizClaimVoucherDetailsById) {
        this.bizClaimVoucherDetailsById = bizClaimVoucherDetailsById;
    }
}
