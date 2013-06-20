package net.schastny.contactmanager.web;

import net.schastny.contactmanager.service.WicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
public class WicketController {

    @Autowired
    WicketService wicketService;

    @RequestMapping("/open")
    public String Open() throws IOException {
        try {
            wicketService.open();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return "redirect:/index";
    }

    @RequestMapping("/panic")
    public String Panic() throws IOException {
        try {
            wicketService.panic();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return "redirect:/index";
    }


}
