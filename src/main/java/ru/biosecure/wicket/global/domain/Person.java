package ru.biosecure.wicket.global.domain;

import org.hibernate.type.BlobType;
import ru.biosecure.wicket.global.domain.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person extends BaseEntity{

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "MIDDLENAME")
    private String middlename;

    @Column(name = "LASTNAME")
    private String lastname;

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
}