package ru.biosecure.wicket.core.web.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 29.06.13
 * Time: 23:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping
public class MediatorController {

    @RequestMapping("/app")
    public String getMainApp() {
        return "app";
    }

    @RequestMapping("/app/mainTemplate")
    public String getTemplate() {
        return "mainPane";
    }
}
