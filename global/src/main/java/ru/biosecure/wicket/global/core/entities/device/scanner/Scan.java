package ru.biosecure.wicket.global.core.entities.device.scanner;

import ru.biosecure.wicket.global.core.entities.base.BaseEntity;
import ru.biosecure.wicket.global.core.entities.person.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Created by inver on 10.12.13.
 */
@Entity
@Table(name = "SCAN")
public class Scan extends BaseEntity {
    @Lob
    @Column
    private byte[] data;

    private Person person;

    private Scanner scanner;

}
