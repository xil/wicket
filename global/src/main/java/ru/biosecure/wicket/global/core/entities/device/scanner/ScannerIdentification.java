package ru.biosecure.wicket.global.core.entities.device.scanner;

import ru.biosecure.wicket.global.core.entities.person.Person;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by inver on 10.12.13.
 */
@Entity
@Table(name = "SCANNER_IDENTIFICATION")
//TODO extends from abstract persistable
public class ScannerIdentification {

    private Date createdDate;

    private Person person;

    private Scanner scanner;
}
