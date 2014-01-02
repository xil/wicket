package ru.biosecure.wicket.global.core.entities;

import ru.biosecure.wicket.global.core.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: Alexey Nevinsky
 * Date: 21.10.13 22:41
 */

@Entity
@Table(name = "SYS_CONFIG")
public class SysConfig extends BaseEntity {

    @Column(name = "NAME", length = 200)
    private String name;

    @Column(name = "VALUE", length = 200)
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
