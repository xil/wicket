/*
 * Copyright (c) 2010 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.

 * Author: Konstantin Krivopustov
 * Created: 20.08.2010 15:16:39
 *
 * $Id: TaskmanFileEncoder.java 635 2010-08-26 12:34:23Z krivopustov $
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class StopDaemonTest {

    public static final String PALM_DEAMON_LOG = "/root/palmd.pid";

    public static void main(String[] args) throws Exception {
        File logFile = new File(PALM_DEAMON_LOG);
        if (!logFile.exists()) return;
        BufferedReader br = new BufferedReader(new FileReader(logFile));
        Runtime run = Runtime.getRuntime();
        try {
            String pid;
            pid = br.readLine();
            if (!isEmpty(pid)) {
                Process process = run.exec("kill " + pid);
                process.waitFor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
