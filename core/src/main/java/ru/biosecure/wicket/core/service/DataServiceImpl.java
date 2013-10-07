package ru.biosecure.wicket.core.service;

import org.springframework.stereotype.Service;
import ru.biosecure.wicket.global.core.entities.base.BaseEntity;
import ru.biosecure.wicket.global.scanner.DataService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 02.10.13
 * Time: 0:29
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DataServiceImpl implements DataService {

    @Override
    public void commit(List<BaseEntity> baseEntity) {

    }

    @Override
    public void commit(BaseEntity baseEntity) {

    }
}
