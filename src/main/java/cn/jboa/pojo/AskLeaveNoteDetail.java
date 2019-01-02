package cn.jboa.pojo;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * 请假条详细信息实体类
 */
public class AskLeaveNoteDetail {
    private int id;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer day;
    private String reason;
    private AskLeaveNote askLeaveNoteByLeavaId;
    private LeaveType leaveTypeByLeaveTypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AskLeaveNoteDetail that = (AskLeaveNoteDetail) o;
        return id == that.id &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(day, that.day) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, day, reason);
    }

    public AskLeaveNote getAskLeaveNoteByLeavaId() {
        return askLeaveNoteByLeavaId;
    }

    public void setAskLeaveNoteByLeavaId(AskLeaveNote askLeaveNoteByLeavaId) {
        this.askLeaveNoteByLeavaId = askLeaveNoteByLeavaId;
    }

    public LeaveType getLeaveTypeByLeaveTypeId() {
        return leaveTypeByLeaveTypeId;
    }

    public void setLeaveTypeByLeaveTypeId(LeaveType leaveTypeByLeaveTypeId) {
        this.leaveTypeByLeaveTypeId = leaveTypeByLeaveTypeId;
    }
}
