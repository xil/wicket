package ru.biosecure.wicket.global.core.enums;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 18.07.13
 * Time: 23:40
 * To change this template use File | Settings | File Templates.
 */
public enum ScanExecutionResult {
    EXECUTING, //in process of scanning
    SUCCESS, //all right
    NEED_CORRECTING, //e.g. turn hand right
    FAILED //e.g. scanner is down
}
