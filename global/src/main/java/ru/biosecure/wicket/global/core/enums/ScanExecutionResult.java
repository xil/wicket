package ru.biosecure.wicket.global.core.enums;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 18.07.13
 * Time: 23:40
 * To change this template use File | Settings | File Templates.
 */
public enum ScanExecutionResult implements EnumClass<String> {
    EXECUTING("EXECUTING"), //in process of scanning
    SUCCESS("SUCCESS"), //all right
    NEED_CORRECTING("NEED_CORRECTING"), //e.g. turn hand right
    FAILED("FAILED"); //e.g. scanner is down

    private String id;

    ScanExecutionResult(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static ScanExecutionResult fromId(String id) {
        if ("EXECUTING".equals(id))
            return EXECUTING;
        else if ("SUCCESS".equals(id))
            return SUCCESS;
        else if ("NEED_CORRECTING".equals(id))
            return NEED_CORRECTING;
        else if ("FAILED".equals(id))
            return FAILED;
        else
            return null;
    }
    }
