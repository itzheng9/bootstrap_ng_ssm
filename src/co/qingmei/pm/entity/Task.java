package co.qingmei.pm.entity;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private Integer id;

    private Integer pid;

    private String name;

    private Date createtime;

    private Integer createuid;

    private Integer actionuid;


    private  String  createUserName;
    private  String  actionUserName;

    private Date finishtime;

    private String descc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getDescc() {
        return descc;
    }

    public void setDescc(String descc) {
        this.descc = descc;
    }


    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getActionUserName() {
        return actionUserName;
    }

    public void setActionUserName(String actionUserName) {
        this.actionUserName = actionUserName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        Task other = (Task) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getCreateuid() == null ? other.getCreateuid() == null : this.getCreateuid().equals(other.getCreateuid()))
            && (this.getActionuid() == null ? other.getActionuid() == null : this.getActionuid().equals(other.getActionuid()))
            && (this.getFinishtime() == null ? other.getFinishtime() == null : this.getFinishtime().equals(other.getFinishtime()))
            && (this.getDescc() == null ? other.getDescc() == null : this.getDescc().equals(other.getDescc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getCreateuid() == null) ? 0 : getCreateuid().hashCode());
        result = prime * result + ((getActionuid() == null) ? 0 : getActionuid().hashCode());
        result = prime * result + ((getFinishtime() == null) ? 0 : getFinishtime().hashCode());
        result = prime * result + ((getDescc() == null) ? 0 : getDescc().hashCode());
        return result;
    }
}