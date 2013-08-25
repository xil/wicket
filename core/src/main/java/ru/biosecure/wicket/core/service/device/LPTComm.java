package ru.biosecure.wicket.core.service.device;

import java.io.IOException;

public class LPTComm {

        private int portBase;

        public LPTComm (int portBase)
        {
            this.portBase = portBase;
        }

        /*public int read ()
        {
            return LPTComm.readOneByte (this.portBase+1);
        }*/

        public void write (byte oneByte) throws IOException {
            LPTComm.writeOneByte (this.portBase, oneByte);

        }

        /*public static int readOneByte (int address){

        }   */

        public static void writeOneByte (int address, byte oneByte)throws IOException{
            StringBuilder str = new StringBuilder();
            str.append("lptdriver --base ");
            str.append(Integer.toHexString(address));
            str.append(" --write ");
            str.append(Integer.toHexString(oneByte));
            System.out.print(str.toString());
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(str.toString());/*"lptdriver --base 0x378 --write 0x08");
            try {
                Thread.sleep(50);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            runtime = Runtime.getRuntime();
            process = runtime.exec("lptdriver --base 0x378 --write 0x00");
//str.toString());*/
        }
    }
