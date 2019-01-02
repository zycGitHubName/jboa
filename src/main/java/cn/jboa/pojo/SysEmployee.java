package cn.jboa.pojo;

import java.util.Collection;
import java.util.Objects;

/**
 * 员工实体类
 */
public class SysEmployee {
    private String sn;
    private String name;
    private String password;
    private String status;
    private Collection<AskLeaveNote> askLeaveNotesBySn;
    private Collection<BizClaimVoucher> bizClaimVouchersBySn;
    private SysPosition sysPositionByPositionId;
    private SysDepartment sysDepartmentByDepartmentId;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        SysEmployee that = (SysEmployee) o;
        return Objects.equals(sn, that.sn) &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sn, name, password, status);
    }

    public Collection<AskLeaveNote> getAskLeaveNotesBySn() {
        return askLeaveNotesBySn;
    }

    public void setAskLeaveNotesBySn(Collection<AskLeaveNote> askLeaveNotesBySn) {
        this.askLeaveNotesBySn = askLeaveNotesBySn;
    }

    public Collection<BizClaimVoucher> getBizClaimVouchersBySn() {
        return bizClaimVouchersBySn;
    }

    public void setBizClaimVouchersBySn(Collection<BizClaimVoucher> bizClaimVouchersBySn) {
        this.bizClaimVouchersBySn = bizClaimVouchersBySn;
    }

    public SysPosition getSysPositionByPositionId() {
        return sysPositionByPositionId;
    }

    public void setSysPositionByPositionId(SysPosition sysPositionByPositionId) {
        this.sysPositionByPositionId = sysPositionByPositionId;
    }

    public SysDepartment getSysDepartmentByDepartmentId() {
        return sysDepartmentByDepartmentId;
    }

    public void setSysDepartmentByDepartmentId(SysDepartment sysDepartmentByDepartmentId) {
        this.sysDepartmentByDepartmentId = sysDepartmentByDepartmentId;
    }
}
