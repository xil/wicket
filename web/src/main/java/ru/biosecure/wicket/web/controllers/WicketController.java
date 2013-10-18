package ru.biosecure.wicket.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.biosecure.wicket.global.wicket.WicketService;

import javax.inject.Inject;
import java.io.IOException;


@Controller
@RequestMapping("/ws/rest/wicket")
public class WicketController implements SimpleController {

    @Inject
    private WicketService wicketService;

    @Override
    public String getScreenTemplate() {

        return null;
    }

    @RequestMapping("/state")
    public String getState() {
        return "";
    }


    @RequestMapping("/open")
    public void Open() throws IOException {
        try {
            wicketService.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/panic")
    public void Panic() throws IOException {
        try {
            wicketService.panic();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
