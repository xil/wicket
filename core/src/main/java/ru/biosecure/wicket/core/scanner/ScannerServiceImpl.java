package ru.biosecure.wicket.core.scanner;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.scanner.ScanResult;
import ru.biosecure.wicket.global.core.entities.scanner.ScannerTask;
import ru.biosecure.wicket.global.core.enums.ScanExecutionResult;
import ru.biosecure.wicket.global.core.enums.ScanTaskType;
import ru.biosecure.wicket.global.scanner.PersonBean;
import ru.biosecure.wicket.global.scanner.ScannerService;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 01.10.13
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ScannerServiceImpl implements ScannerService {

    private static final String LOG_PATH = "/home/palm-deamon.log";
    public static final String PALM_DEAMON_MESSAGE = "/root/palm-message.log";
    public static final String PATH_DAEMON = "/opt/palmd/Debug/palmd";
    private static final String[] START = {PATH_DAEMON};
    private static final String[] STOP = {"/opt/sh", "-c"};
    private static final String[] ENROLL = {PATH_DAEMON, "-e"};
    private static final String[] ENROLL_STOP = {PATH_DAEMON, "-es"};

    @Inject
    private PersonBean personBean;

    @Override
    public ScannerTask executeTask(ScanTaskType taskType) {
        ScannerTask scannerTask = null;
        switch (taskType) {
            case SCAN:
                enroll();
                scannerTask = scanStart();
                break;
            case IDENTIFICATION:
                enrollStop();
                scannerTask = identification();
                break;
            default:
                //todo exeption
        }
        return scannerTask;
    }

    public void startDaemon() {
        exec(START);
    }

    public void stopDaemon() {
        //todo
    }

    public void enroll() {
        exec(ENROLL);
    }

    public void enrollStop() {
        exec(ENROLL_STOP);
    }

    private void exec(String[] command) {
        Runtime run = Runtime.getRuntime();
        Process process = null;
        try {
            process = run.exec(command);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ScannerTask scanStart() {
        ScannerTask scannerTask = new ScannerTask();
        scannerTask.setResult(ScanExecutionResult.EXECUTING);
        return scannerTask;
    }

    private ScannerTask identification() {
//        ScannerTask scannerTask = new ScannerTask();
//        return scannerTask;
        return null;
    }

    public void scan() {
        enroll();
    }

    @Override
    public void scan(Person person) {
        enroll();
        personBean.setPerson(person);
    }

    @Override
    public String getCurrentState() {
        return null;
    }

    @Override
    public ScanResult getResult(Person person) {
        File logFile = new File(PALM_DEAMON_MESSAGE);
        ScanExecutionResult scanExecutionResult = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(logFile));
            String line;
            boolean next = false;
            while ((line = br.readLine()) != null) {
                if (isNotEmpty(line)) {

                }
            }
            scanExecutionResult = ScanExecutionResult.fromId(line);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ScanResult scanResult = new ScanResult();
        scanResult.setResult(scanExecutionResult);
        scanResult.setResultMessage(scanExecutionResult.getId());
        return scanResult;
    }

    private boolean isNotEmpty(String str) {
        return (!(str == null || str.isEmpty()));
    }
}
