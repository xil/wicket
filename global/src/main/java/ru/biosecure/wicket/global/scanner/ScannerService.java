package ru.biosecure.wicket.global.scanner;

import ru.biosecure.wicket.global.core.entities.scanner.ScannerTask;
import ru.biosecure.wicket.global.core.enums.ScanTaskType;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 18.07.13
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
public interface ScannerService {
    ScannerTask executeTask(ScanTaskType taskType);
}
