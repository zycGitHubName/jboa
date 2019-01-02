package cn.jboa.pojo;

import java.util.Objects;

/**
 * 报销单详细信息实体类
 */
public class BizClaimVoucherDetail {
    private int id;
    private String item;
    private double account;
    private String des;
    private BizClaimVoucher bizClaimVoucherByMainId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BizClaimVoucherDetail that = (BizClaimVoucherDetail) o;
        return id == that.id &&
                Double.compare(that.account, account) == 0 &&
                Objects.equals(item, that.item) &&
                Objects.equals(des, that.des);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, account, des);
    }

    public BizClaimVoucher getBizClaimVoucherByMainId() {
        return bizClaimVoucherByMainId;
    }

    public void setBizClaimVoucherByMainId(BizClaimVoucher bizClaimVoucherByMainId) {
        this.bizClaimVoucherByMainId = bizClaimVoucherByMainId;
    }
}
