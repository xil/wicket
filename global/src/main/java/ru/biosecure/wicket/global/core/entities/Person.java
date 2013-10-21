package ru.biosecure.wicket.global.core.entities;

import org.springframework.util.CollectionUtils;
import ru.biosecure.wicket.global.core.entities.base.BaseEntity;
import ru.biosecure.wicket.global.core.entities.security.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PERSON")
public class Person extends BaseEntity {
    private static final long serialVersionUID = 4410504516807797206L;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "MIDDLENAME")
    private String middlename;

    @Column(name = "LASTNAME")
    private String lastname;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<PersonToScan> scans;

    public int scansCount() {
        if (!CollectionUtils.isEmpty(getScans())) {
            return getScans().size();
        }
        return 0;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PersonToScan> getScans() {
        return scans;
    }

    public void setScans(List<PersonToScan> scans) {
        this.scans = scans;
    }
}