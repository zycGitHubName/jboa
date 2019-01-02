package cn.jboa.pojo;

import java.util.Collection;
import java.util.Objects;

/**
 * 员工职位实体类
 */
public class SysPosition {
    private int id;
    private String nameCn;
    private String nameEn;
    private Collection<SysEmployee> sysEmployeesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysPosition that = (SysPosition) o;
        return id == that.id &&
                Objects.equals(nameCn, that.nameCn) &&
                Objects.equals(nameEn, that.nameEn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCn, nameEn);
    }

    public Collection<SysEmployee> getSysEmployeesById() {
        return sysEmployeesById;
    }

    public void setSysEmployeesById(Collection<SysEmployee> sysEmployeesById) {
        this.sysEmployeesById = sysEmployeesById;
    }
}
