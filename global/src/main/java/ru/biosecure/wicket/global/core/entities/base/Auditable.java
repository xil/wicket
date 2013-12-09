package ru.biosecure.wicket.global.core.entities.base;


import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * Created by inver on 10.12.13.
 */
public interface Auditable<ID extends Serializable> extends Persistable<ID> {
//    Date getCreatedDate();
//    void setCreatedDate();
//
//    Date getDeletedDate();
//    void setCreatedDate();
//
//    Date getCreatedDate();
//    void setCreatedDate();
}
