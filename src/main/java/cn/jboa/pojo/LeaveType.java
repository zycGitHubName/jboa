package cn.jboa.pojo;

import java.util.Collection;
import java.util.Objects;

/**
 * 休假类型实体类
 */
public class LeaveType {
    private int id;
    private String name;
    private Collection<AskLeaveNoteDetail> askLeaveNoteDetailsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveType leaveType = (LeaveType) o;
        return id == leaveType.id &&
                Objects.equals(name, leaveType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<AskLeaveNoteDetail> getAskLeaveNoteDetailsById() {
        return askLeaveNoteDetailsById;
    }

    public void setAskLeaveNoteDetailsById(Collection<AskLeaveNoteDetail> askLeaveNoteDetailsById) {
        this.askLeaveNoteDetailsById = askLeaveNoteDetailsById;
    }
}
