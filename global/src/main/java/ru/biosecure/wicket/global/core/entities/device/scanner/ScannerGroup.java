package ru.biosecure.wicket.global.core.entities.device.scanner;

import ru.biosecure.wicket.global.core.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by inver on 10.12.13.
 */
@Entity
@Table(name = "SCANNER_GROUP")
public class ScannerGroup extends BaseEntity {
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Scanner.class)
    @JoinTable(name = "SCANNER_TO_GROUP",
            joinColumns = {@JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "SCANNER_ID", referencedColumnName = "ID")})
    private Set<Scanner> scanners;

}
