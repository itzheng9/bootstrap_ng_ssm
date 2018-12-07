package co.qingmei.pm.entity;

import java.io.Serializable;
import java.util.Date;

public class Bug implements Serializable {
    private Integer id;

    private String name;

    private Date createtime;

    private Integer createuid;

    private Integer actionuid;

    private Date finishtime;

    private  Integer  pid;

    private static final long serialVersionUID = 1L;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreateuid() {
        return createuid;
    }

    public void setCreateuid(Integer createuid) {
        this.createuid = createuid;
    }

    public Integer getActionuid() {
        return actionuid;
    }

    public void setActionuid(Integer actionuid) {
        this.actionuid = actionuid;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
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
        Bug other = (Bug) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getCreateuid() == null ? other.getCreateuid() == null : this.getCreateuid().equals(other.getCreateuid()))
            && (this.getActionuid() == null ? other.getActionuid() == null : this.getActionuid().equals(other.getActionuid()))
            && (this.getFinishtime() == null ? other.getFinishtime() == null : this.getFinishtime().equals(other.getFinishtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getCreateuid() == null) ? 0 : getCreateuid().hashCode());
        result = prime * result + ((getActionuid() == null) ? 0 : getActionuid().hashCode());
        result = prime * result + ((getFinishtime() == null) ? 0 : getFinishtime().hashCode());
        return result;
    }
}