package cn.jboa.pojo;

import java.util.Collection;
import java.util.Objects;

/**
 * 部门实体类
 */
public class SysDepartment {
    private int id;
    private String name;
    private Collection<SysEmployee> sysEmployeesById;

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
        SysDepartment that = (SysDepartment) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<SysEmployee> getSysEmployeesById() {
        return sysEmployeesById;
    }

    public void setSysEmployeesById(Collection<SysEmployee> sysEmployeesById) {
        this.sysEmployeesById = sysEmployeesById;
    }
}
