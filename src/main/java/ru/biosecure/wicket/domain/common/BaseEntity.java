package ru.biosecure.wicket.domain.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 20.06.13
 * Time: 20:04
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(length = 16, name = "ID", unique = true, nullable = false)
    protected UUID id;

    @Column(name = "CREATED_BY", length = 60)
    protected String createdBy;

    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    protected Date createDate;

    @Column(name = "UPDATED_BY", length = 60)
    protected String updatedBy;

    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.DATE)
    protected Date updateDate;

    @Column(name = "DELETED_BY", length = 60)
    protected String deletedBy;

    @Column(name = "DELETE_DATE")
    @Temporal(TemporalType.DATE)
    protected Date deleteDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }
}
