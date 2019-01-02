package cn.jboa.pojo;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * 报销单审批结果实体类
 */
public class BizCheckResult {
    private int id;
    private Timestamp checkTime;
    private String checkerSn;
    private String result;
    private String comm;
    private BizClaimVoucher bizClaimVoucherByClaimId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckerSn() {
        return checkerSn;
    }

    public void setCheckerSn(String checkerSn) {
        this.checkerSn = checkerSn;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BizCheckResult that = (BizCheckResult) o;
        return id == that.id &&
                Objects.equals(checkTime, that.checkTime) &&
                Objects.equals(checkerSn, that.checkerSn) &&
                Objects.equals(result, that.result) &&
                Objects.equals(comm, that.comm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkTime, checkerSn, result, comm);
    }

    public BizClaimVoucher getBizClaimVoucherByClaimId() {
        return bizClaimVoucherByClaimId;
    }

    public void setBizClaimVoucherByClaimId(BizClaimVoucher bizClaimVoucherByClaimId) {
        this.bizClaimVoucherByClaimId = bizClaimVoucherByClaimId;
    }
}
