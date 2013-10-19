package ru.biosecure.wicket.global.scanner;

import ru.biosecure.wicket.global.core.entities.base.BaseEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 02.10.13
 * Time: 0:28
 * To change this template use File | Settings | File Templates.
 */
public interface DataService {

    void commit(List<BaseEntity> baseEntity);

    void commit(BaseEntity baseEntity);
}
