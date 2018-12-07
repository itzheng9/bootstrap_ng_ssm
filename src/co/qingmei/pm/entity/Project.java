package co.qingmei.pm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Project implements Serializable {
    private Integer id;

    private String name;

    private Date begintime;

    private Date endtime;

    private Integer master;

    private String descc;


    private List<Employee> employeeList;
    private  List<Task> taskList;
    private  List<Bug> bugList;


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Bug> getBugList() {
        return bugList;
    }

    public void setBugList(List<Bug> bugList) {
        this.bugList = bugList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    public String getDescc() {
        return descc;
    }

    public void setDescc(String descc) {
        this.descc = descc;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Project other = (Project) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBegintime() == null ? other.getBegintime() == null : this.getBegintime().equals(other.getBegintime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getMaster() == null ? other.getMaster() == null : this.getMaster().equals(other.getMaster()))
            && (this.getDescc() == null ? other.getDescc() == null : this.getDescc().equals(other.getDescc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBegintime() == null) ? 0 : getBegintime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getMaster() == null) ? 0 : getMaster().hashCode());
        result = prime * result + ((getDescc() == null) ? 0 : getDescc().hashCode());
        return result;
    }
}