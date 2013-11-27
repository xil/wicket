package ru.biosecure.wicket.global.core.entities;

import ru.biosecure.wicket.global.core.entities.base.BaseEntity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 04.10.13
 * Time: 23:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PERSON_TO_SCAN")
public class PersonToScan extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCAN_ID")
    private Scan scan;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Scan getScan() {
        return scan;
    }

    public void setScan(Scan scan) {
        this.scan = scan;
    }
}
