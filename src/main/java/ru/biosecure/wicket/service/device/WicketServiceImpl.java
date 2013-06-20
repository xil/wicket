package ru.biosecure.wicket.service.device;

import org.springframework.stereotype.Service;
import ru.biosecure.wicket.global.device.WicketService;

import java.io.IOException;

@Service
public class WicketServiceImpl implements WicketService {
    private LPTComm lp0;

    @Override
    public void open() throws IOException {
        lp0=new LPTComm(0x378);
        try {
            lp0.write((byte)0x10);
            try {
                Thread.sleep(50);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            lp0.write((byte)0x00);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void panic() throws IOException {
        lp0=new LPTComm(0x378);
        try {
            lp0.write((byte)0x08);
            try {
                Thread.sleep(50);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            lp0.write((byte)0x00);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
