package ru.biosecure.wicket.core.scanner;

import org.springframework.stereotype.Service;
import ru.biosecure.wicket.global.core.entities.scanner.ScannerTask;
import ru.biosecure.wicket.global.core.enums.ScanTaskExecutionResult;
import ru.biosecure.wicket.global.core.enums.ScanTaskType;
import ru.biosecure.wicket.global.scanner.ScannerService;

import java.io.IOException;

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
    public static final String PATH_DAEMON = "/opt/palmd/Debug/palmd";
    private static final String[] START = {PATH_DAEMON};
    private static final String[] STOP = {"/opt/sh", "-c"};
    private static final String[] ENROLL = {PATH_DAEMON, "-e"};
    private static final String[] ENROLL_STOP = {PATH_DAEMON, "-es"};

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
        scannerTask.setResult(ScanTaskExecutionResult.EXECUTING);
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
}
