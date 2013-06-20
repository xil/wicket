package ru.biosecure.wicket.global.device;


import java.io.IOException;

public interface WicketService {

    public void open() throws IOException;

    public void panic() throws IOException;

}
