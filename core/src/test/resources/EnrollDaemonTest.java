
import java.io.IOException;

public class EnrollDaemonTest {

    private static final String[] ENROLL = {"/opt/palmd/Debug/palmd", "-e"};

    public static void main(String[] args) throws Exception {
        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec(ENROLL);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
