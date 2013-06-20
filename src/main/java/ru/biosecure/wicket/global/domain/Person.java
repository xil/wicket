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

    @Column(name = "REGDATE")
    @GeneratedValue
    private String regdate;

    @Column(name = "EXPDATE")
    private String expdate;

    @Column(name = "PHOTO")
    private BlobType photo;

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

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public BlobType getPhoto() {
        return photo;
    }

    public void setPhoto(BlobType photo) {
        this.photo = photo;
    }
}