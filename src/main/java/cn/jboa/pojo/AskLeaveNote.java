package cn.jboa.pojo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * 请假条实体类
 */
public class AskLeaveNote {
    private int id;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private String status;
    private SysEmployee sysEmployeeByNextDealSn;
    private SysEmployee sysEmployeeByCreateSn;
    private Collection<AskLeaveNoteDetail> askLeaveNoteDetailsById;

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
        AskLeaveNote that = (AskLeaveNote) o;
        return id == that.id &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(modifyTime, that.modifyTime) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,  createTime, modifyTime, status);
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

    public Collection<AskLeaveNoteDetail> getAskLeaveNoteDetailsById() {
        return askLeaveNoteDetailsById;
    }

    public void setAskLeaveNoteDetailsById(Collection<AskLeaveNoteDetail> askLeaveNoteDetailsById) {
        this.askLeaveNoteDetailsById = askLeaveNoteDetailsById;
    }
}
