/*
 * Copyright (c) 2010 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.

 * Author: Konstantin Krivopustov
 * Created: 20.08.2010 15:16:39
 *
 * $Id: TaskmanFileEncoder.java 635 2010-08-26 12:34:23Z krivopustov $
 */

import java.io.IOException;

public class StartDaemonTest {

    private static final String[] ENROLL = {"/opt/palmd/Debug/palmd"};
    //private static final String[] ENROLL = {"/opt/palmd/Debug/palmd"};

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
