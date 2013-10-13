package ru.biosecure.wicket.global.core.app;

import ru.biosecure.wicket.global.core.entities.Scan;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 14.10.13
 * Time: 1:06
 * To change this template use File | Settings | File Templates.
 */
public interface ScanService {

    public void addScan(Scan scan);

    Scan getScanById(Long id);

    public List<Scan> scanList();

}
