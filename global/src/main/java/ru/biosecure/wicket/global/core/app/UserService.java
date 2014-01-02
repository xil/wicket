package ru.biosecure.wicket.global.core.app;

import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.scanner.ScanResult;

/**
 * User: Alexey Nevinsky
 * Date: 24.10.13 23:00
 */

//DO NOT CHANGE THIS SERVICE!!!
public interface UserService {
    ScanResult getScanResult(Person person);

}
