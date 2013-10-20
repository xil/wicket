import ru.biosecure.wicket.global.core.entities.scanner.ScanResult;
import ru.biosecure.wicket.global.core.enums.ScanExecutionResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 21.10.13
 * Time: 2:01
 * To change this template use File | Settings | File Templates.
 */
public class DaemonMessageLogTest {

    public static final String PALM_DAEMON_MESSAGE = "C:\\pan\\palm-message.log";

    public static void main(String[] args) throws Exception {
        File logFile = new File(PALM_DAEMON_MESSAGE);
        ScanExecutionResult scanExecutionResult = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(logFile));
            String line;
            String lastNotEmptyLine = null;
            boolean next = false;
            while ((line = br.readLine()) != null) {
                if (isNotEmpty(line)) {
                    lastNotEmptyLine = line;
                }
            }
            scanExecutionResult = ScanExecutionResult.fromId(lastNotEmptyLine);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ScanResult scanResult = new ScanResult();
        scanResult.setResult(scanExecutionResult);
        scanResult.setResultMessage(scanExecutionResult.getId());
    }


    private static boolean isNotEmpty(String str) {
        return (!(str == null || str.isEmpty()));
    }
}
