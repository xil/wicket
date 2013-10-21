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
    SUCCESS("Сканирование завершено успешно"), //all right
    NEED_CORRECTING("NEED_CORRECTING"), //e.g. turn hand right
    FAILED("FAILED"), //e.g. scanner is down

    PvAPI_NOTIFY_CAP_GUID_START("PvAPI_NOTIFY_CAP_GUID_START"),
    PvAPI_NOTIFY_CAP_GUID_BADIMAGE("PvAPI_NOTIFY_CAP_GUID_BADIMAGE"),
    PvAPI_NOTIFY_CAP_GUID_NO_HANDS("PvAPI_NOTIFY_CAP_GUID_NO_HANDS"),
    PvAPI_NOTIFY_CAP_GUID_MOVING("PvAPI_NOTIFY_CAP_GUID_MOVING"),
    PvAPI_NOTIFY_CAP_GUID_LESSINFO("PvAPI_NOTIFY_CAP_GUID_LESSINFO"),
    PvAPI_NOTIFY_CAP_GUID_RIGHT("PvAPI_NOTIFY_CAP_GUID_RIGHT"),
    PvAPI_NOTIFY_CAP_GUID_DOWN("PvAPI_NOTIFY_CAP_GUID_DOWN"),
    PvAPI_NOTIFY_CAP_GUID_LEFT("PvAPI_NOTIFY_CAP_GUID_LEFT"),
    PvAPI_NOTIFY_CAP_GUID_UP("PvAPI_NOTIFY_CAP_GUID_UP"),
    PvAPI_NOTIFY_CAP_GUID_FAR("PvAPI_NOTIFY_CAP_GUID_FAR"),
    PvAPI_NOTIFY_CAP_GUID_NEAR("PvAPI_NOTIFY_CAP_GUID_NEAR"),
    PvAPI_NOTIFY_CAP_GUID_CAPTURING("PvAPI_NOTIFY_CAP_GUID_CAPTURING"),
    PvAPI_NOTIFY_CAP_GUID_PITCH_UP("PvAPI_NOTIFY_CAP_GUID_PITCH_UP"),
    PvAPI_NOTIFY_CAP_GUID_PITCH_DOWN("PvAPI_NOTIFY_CAP_GUID_PITCH_DOWN"),
    PvAPI_NOTIFY_CAP_GUID_ROLL_RIGHT("PvAPI_NOTIFY_CAP_GUID_ROLL_RIGHT"),
    PvAPI_NOTIFY_CAP_GUID_ROLL_LEFT("PvAPI_NOTIFY_CAP_GUID_ROLL_LEFT"),
    PvAPI_NOTIFY_CAP_GUID_YAW_RIGHT("PvAPI_NOTIFY_CAP_GUID_YAW_RIGHT"),
    PvAPI_NOTIFY_CAP_GUID_YAW_LEFT("PvAPI_NOTIFY_CAP_GUID_YAW_LEFT"),
    PvAPI_NOTIFY_CAP_GUID_ROUND("PvAPI_NOTIFY_CAP_GUID_ROUND"),
    PvAPI_NOTIFY_CAP_GUID_ADJUST_LIGHT("PvAPI_NOTIFY_CAP_GUID_ADJUST_LIGHT"),
    PvAPI_NOTIFY_CAP_GUID_ADJUST_NG("PvAPI_NOTIFY_CAP_GUID_ADJUST_NG"),
    PvAPI_NOTIFY_CAP_GUID_PHASE_END("PvAPI_NOTIFY_CAP_GUID_PHASE_END"),
    CLEAN("Уберите руку с сенсора"),
    UNDEFINED("UNDEFINED"),
    CANNOT_CONNECT("Не получилось подключиться к устройству");


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
        else if ("PvAPI_NOTIFY_CAP_GUID_START".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_START;
        else if ("PvAPI_NOTIFY_CAP_GUID_BADIMAGE".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_BADIMAGE;
        else if ("PvAPI_NOTIFY_CAP_GUID_NO_HANDS".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_NO_HANDS;
        else if ("PvAPI_NOTIFY_CAP_GUID_MOVING".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_MOVING;
        else if ("PvAPI_NOTIFY_CAP_GUID_LESSINFO".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_LESSINFO;
        else if ("PvAPI_NOTIFY_CAP_GUID_RIGHT".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_RIGHT;
        else if ("PvAPI_NOTIFY_CAP_GUID_DOWN".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_DOWN;
        else if ("PvAPI_NOTIFY_CAP_GUID_LEFT".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_LEFT;
        else if ("PvAPI_NOTIFY_CAP_GUID_UP".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_UP;
        else if ("PvAPI_NOTIFY_CAP_GUID_FAR".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_FAR;
        else if ("PvAPI_NOTIFY_CAP_GUID_NEAR".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_NEAR;
        else if ("PvAPI_NOTIFY_CAP_GUID_CAPTURING".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_CAPTURING;
        else if ("PvAPI_NOTIFY_CAP_GUID_PITCH_UP".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_PITCH_UP;
        else if ("PvAPI_NOTIFY_CAP_GUID_PITCH_DOWN".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_PITCH_DOWN;
        else if ("PvAPI_NOTIFY_CAP_GUID_ROLL_RIGHT".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_ROLL_RIGHT;
        else if ("PvAPI_NOTIFY_CAP_GUID_ROLL_LEFT".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_ROLL_LEFT;
        else if ("PvAPI_NOTIFY_CAP_GUID_YAW_RIGHT".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_YAW_RIGHT;
        else if ("PvAPI_NOTIFY_CAP_GUID_YAW_LEFT".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_YAW_LEFT;
        else if ("PvAPI_NOTIFY_CAP_GUID_ROUND".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_ROUND;
        else if ("PvAPI_NOTIFY_CAP_GUID_ADJUST_LIGHT".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_ADJUST_LIGHT;
        else if ("PvAPI_NOTIFY_CAP_GUID_ADJUST_NG".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_ADJUST_NG;
        else if ("PvAPI_NOTIFY_CAP_GUID_PHASE_END".equals(id))
            return PvAPI_NOTIFY_CAP_GUID_PHASE_END;
        else if ("Уберите руку с сенсора".equals(id))
            return CLEAN;
        else if ("FAILED".equals(id))
            return FAILED;
        else if ("Не получилось подключиться к устройству".equals(id))
            return CANNOT_CONNECT;
        else
            return UNDEFINED;
    }
}
