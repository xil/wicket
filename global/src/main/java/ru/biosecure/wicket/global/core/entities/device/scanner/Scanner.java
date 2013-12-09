package ru.biosecure.wicket.global.core.entities.device.scanner;

import ru.biosecure.wicket.global.core.entities.device.Device;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by inver on 10.12.13.
 */
@Entity
@Table(name = "SCANNER")
public class Scanner extends Device {
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = ScannerGroup.class)
    @JoinTable(name = "SCANNER_TO_GROUP",
            joinColumns = {@JoinColumn(name = "SCANNER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")})
    private Set<ScannerGroup> groups;
}
