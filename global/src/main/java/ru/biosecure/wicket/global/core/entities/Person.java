package ru.biosecure.wicket.global.core.entities;

import ru.biosecure.wicket.global.core.entities.base.BaseEntity;
import ru.biosecure.wicket.global.core.entities.security.User;

import javax.persistence.*;

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
}