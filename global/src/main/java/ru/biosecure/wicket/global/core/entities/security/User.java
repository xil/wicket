package ru.biosecure.wicket.global.core.entities.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.biosecure.wicket.global.core.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Collection;

/**
 * @autor: Alexey Nevinsky
 * Date: 12.07.13 23:37
 */
@Entity
@Table(name = "SEC_USER")
public class User extends BaseEntity implements UserDetails {
    private static final long serialVersionUID = 4340846493375164366L;

    @Column(name = "USERNAME", unique = true)
    protected String username;

    @Column(name = "PASSWORD")
    protected String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = SecRole.class)
    @JoinTable(name = "USER_TO_ROLES",
            joinColumns = {@JoinColumn(name = "USER_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", nullable = false, updatable = false)})
    protected Collection<SecRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
//        TODO in future
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        TODO in future
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//        TODO in future
        return true;
    }

    @Override
    public boolean isEnabled() {
//        TODO in future
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<SecRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<SecRole> roles) {
        this.roles = roles;
    }
}
