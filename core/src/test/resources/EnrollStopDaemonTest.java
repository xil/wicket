
import java.io.IOException;

public class EnrollStopDaemonTest {

    private static final String[] ENROLL_STOP = {"/opt/palmd/Debug/palmd", "-es"};

    public static void main(String[] args) throws Exception {
        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec(ENROLL_STOP);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
