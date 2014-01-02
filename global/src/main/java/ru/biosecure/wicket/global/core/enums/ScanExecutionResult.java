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
        for (ScanExecutionResult result : values()) {
            if (result.id.equals(id))
                return result;
        }
        return null;
    }
}
