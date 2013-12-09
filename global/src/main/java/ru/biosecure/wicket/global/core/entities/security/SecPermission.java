package ru.biosecure.wicket.global.core.entities.security;

import ru.biosecure.wicket.global.core.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Collection;

/**
 * @autor: Alexey Nevinsky
 * Date: 12.07.13 23:37
 */
@Entity
@Table(name = "SEC_PERMISSION")
public class SecPermission extends BaseEntity {
    private static final long serialVersionUID = -3624922556006086151L;

    @Column(name = "PERMISSION_OBJECT")
    protected String permissionObject;

    @Column(name = "ACCESS")
    protected Boolean access;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = SecRole.class)
    @JoinTable(name = "ROLE_TO_PERMISSION",
            joinColumns = {@JoinColumn(name = "PERMISSION_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", nullable = false, updatable = false)})
    protected Collection<SecRole> roles;

    public String getPermissionObject() {
        return permissionObject;
    }

    public void setPermissionObject(String permissionObject) {
        this.permissionObject = permissionObject;
    }

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }
}
