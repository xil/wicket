
import java.io.IOException;

public class RestartDaemonTest {

    private static final String[] RESTART = {"/opt/palmd/Debug/palmd"};

    public static void main(String[] args) throws Exception {
        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec(RESTART);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
