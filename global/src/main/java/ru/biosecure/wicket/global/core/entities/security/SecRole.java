package ru.biosecure.wicket.global.core.entities.security;

import org.springframework.security.core.GrantedAuthority;
import ru.biosecure.wicket.global.core.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Collection;

/**
 * @autor: Alexey Nevinsky
 * Date: 12.07.13 23:37
 */
@Entity
@Table(name = "SEC_ROLE")
public class SecRole extends BaseEntity implements GrantedAuthority {
    private static final long serialVersionUID = -110283291414275205L;

    @Column(name = "NAME", length = 100)
    protected String name;

    @Column(name = "DESCRIPTION", length = 500)
    protected String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = SecPermission.class)
    @JoinTable(name = "ROLE_TO_PERMISSION",
            joinColumns = {@JoinColumn(name = "ROLE_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "PERMISSION_ID", nullable = false, updatable = false)})
    protected Collection<SecPermission> permissions;

    @Override
    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<SecPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<SecPermission> permissions) {
        this.permissions = permissions;
    }
}
