package ru.biosecure.wicket.global.core.app;

import ru.biosecure.wicket.global.core.entities.base.BaseEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 18.10.13
 * Time: 23:27
 * To change this template use File | Settings | File Templates.
 */
public interface BaseDataService {

    List<? extends BaseEntity> findAll();

    <S extends BaseEntity> List<S> save(Iterable<S> entities);

    <S extends BaseEntity> S save(S entity);

    void delete(Iterable<? extends BaseEntity> entities);

    <T extends BaseEntity> void delete(T entity);
}
