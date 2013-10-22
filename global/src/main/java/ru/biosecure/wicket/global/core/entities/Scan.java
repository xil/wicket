package ru.biosecure.wicket.global.core.entities;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 26.06.13
 * Time: 16:02
 * To change this template use File | Settings | File Templates.
 */

import ru.biosecure.wicket.global.core.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Scan from device
 */

@Entity
@Table(name = "SCAN")
public class Scan extends BaseEntity {

    @Column(name = "SCAN_ID")
    protected Long scanId;

    public Long getScanId() {
        return scanId;
    }

    public void setScanId(Long scanId) {
        this.scanId = scanId;
    }
}
