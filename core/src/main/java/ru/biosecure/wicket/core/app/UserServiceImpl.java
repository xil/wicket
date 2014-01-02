package ru.biosecure.wicket.core.app;

import org.springframework.stereotype.Service;
import ru.biosecure.wicket.global.core.app.UserService;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.scanner.ScanResult;
import ru.biosecure.wicket.global.core.enums.ScanExecutionResult;
import ru.biosecure.wicket.global.scanner.ScannerService;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Alexey Nevinsky
 * Date: 24.10.13 23:02
 */
@Service
public class UserServiceImpl implements UserService {
    @Inject
    private ScannerService scannerService;

    @Override
    public ScanResult getScanResult(Person person) {
        ScanResult result = scannerService.getResult(person);
        if (result == null)
            return null;

        ScanResult scanResult = new ScanResult();
        scanResult.setResult(getNormalResult(result.getResult()));
        scanResult.setResultMessage(getNormalString(result.getResultMessage()));
        return scanResult;
    }

    private ScanExecutionResult getNormalResult(ScanExecutionResult badResult) {
        if (badResult != null) {
            switch (badResult) {
                case PvAPI_NOTIFY_CAP_GUID_START:
                    return ScanExecutionResult.EXECUTING;
                case PvAPI_NOTIFY_CAP_GUID_PHASE_END:
                    return ScanExecutionResult.SUCCESS;
                case UNDEFINED:
                    return ScanExecutionResult.FAILED;
                default:
                    return ScanExecutionResult.NEED_CORRECTING;
            }
        }
        return null;
    }

    private String getNormalString(String badString) {
        if (badString == null || badString.isEmpty())
            return "";
        ScanExecutionResult res = ScanExecutionResult.fromId(badString);
        return getEnumKeys().get(res);
    }

    private Map<ScanExecutionResult, String> getEnumKeys() {
        Map<ScanExecutionResult, String> resMap = new HashMap<ScanExecutionResult, String>();
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_START, "scanningStarted");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_BADIMAGE, "scanningBadImage");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_NO_HANDS, "scanningNoHands");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_MOVING, "scanningMoving");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_LESSINFO, "scanningLessInfo");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_RIGHT, "scanningRight");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_DOWN, "scanningDown");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_LEFT, "scanningLeft");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_UP, "scanningUp");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_FAR, "scanningFar");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_NEAR, "scanningNear");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_CAPTURING, "scanningCapturing");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_PITCH_UP, "scanningPitchUp");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_PITCH_DOWN, "scanningPitchDown");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_ROLL_RIGHT, "scanningRollRight");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_ROLL_LEFT, "scanningRollLeft");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_YAW_RIGHT, "scanningYawRight");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_YAW_LEFT, "scanningYawLeft");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_ROUND, "scanningRound");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_ADJUST_LIGHT, "scanningAdjustLight");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_ADJUST_NG, "scanningAdjustNg");
        resMap.put(ScanExecutionResult.PvAPI_NOTIFY_CAP_GUID_PHASE_END, "scanningPhaseEnd");
        resMap.put(ScanExecutionResult.CLEAN, "scanningClean");
        resMap.put(ScanExecutionResult.CANNOT_CONNECT, "scanningDisconnect");
        return resMap;
    }
}

//        +PvAPI_NOTIFY_CAP_GUID_START=Старт
//        +PvAPI_NOTIFY_CAP_GUID_BADIMAGE=Уберите руку и приложите еще раз
//        +PvAPI_NOTIFY_CAP_GUID_NO_HANDS=Приложите руку
//        +PvAPI_NOTIFY_CAP_GUID_MOVING=Не двигайте руку
//        +PvAPI_NOTIFY_CAP_GUID_LESSINFO=Положите руку,распрямив пальцы
//        +PvAPI_NOTIFY_CAP_GUID_RIGHT=Слегка сдвиньте руку влево
//        +PvAPI_NOTIFY_CAP_GUID_DOWN=Слегка подвиньте руку от себя
//        +PvAPI_NOTIFY_CAP_GUID_LEFT=Слегка сдвиньте руку вправо
//        +PvAPI_NOTIFY_CAP_GUID_UP=Слегка подвиньте руку на себя
//        +PvAPI_NOTIFY_CAP_GUID_FAR=Подвиньте руку чуть ближе к сенсору
//        +PvAPI_NOTIFY_CAP_GUID_NEAR=Отодвиньте руку чуть дальше от сенсора
//        +PvAPI_NOTIFY_CAP_GUID_CAPTURING=Захват изображения,не двигайте руку
//        +PvAPI_NOTIFY_CAP_GUID_PITCH_UP=Держите руку ровнее
//        +PvAPI_NOTIFY_CAP_GUID_PITCH_DOWN=Держите руку ровнее
//        +PvAPI_NOTIFY_CAP_GUID_ROLL_RIGHT=Держите руку ровнее
//        +PvAPI_NOTIFY_CAP_GUID_ROLL_LEFT=Держите руку ровнее
//        +PvAPI_NOTIFY_CAP_GUID_YAW_RIGHT=Держите руку параллельно сенсору
//        +PvAPI_NOTIFY_CAP_GUID_YAW_LEFT=Держите руку параллельно сенсору
//        +PvAPI_NOTIFY_CAP_GUID_ROUND=Держите ладонь открытой
//        +PvAPI_NOTIFY_CAP_GUID_ADJUST_LIGHT=Повторная попытка сканирования,не двигайте руку
//        +PvAPI_NOTIFY_CAP_GUID_ADJUST_NG=Повторная попытка сканирования,не двигайте руку
//        +PvAPI_NOTIFY_CAP_GUID_PHASE_END=Готово
//        +clean=Уберите руку и приложите еще раз
//        +scan=Сканирование завершено успешно
//        +disconnect=Не получилось подключиться к устройству