package ru.biosecure.wicket.global.scanner;

import ru.biosecure.wicket.global.core.entities.Person;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 01.10.13
 * Time: 23:47
 * To change this template use File | Settings | File Templates.
 */
public interface DaemonMBean {

    public static final String NAME = "daemon-mbean";

    void notifyId(Object id);

    void failed(Object id);

    void setPerson(Person employee);
}
