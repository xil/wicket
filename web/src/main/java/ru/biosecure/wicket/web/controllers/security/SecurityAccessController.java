package ru.biosecure.wicket.core.web.security;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 29.06.13
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping
public class SecurityAccessController {

    private final Logger logger = Logger.getLogger(getClass());

    @RequestMapping("/")
    public String getIndex() {
        logger.warn("logiiin1");
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(Model model, @RequestParam(required = false) String message) {


        model.addAttribute("error", message);
        logger.warn("logiiin");
        return "login";
    }

    @RequestMapping(value = "/denied")
    public String denied() {
        logger.info("denided");
        return "denied";
    }

    @RequestMapping(value = "/login/failure")
    public String loginFailure() {
        String message = "Login Failure!";
        logger.info("logiiin failure");
        return "redirect:/login?message=" + message;
    }

    @RequestMapping("/login/success")
    public String loginSuccess() {
        return "redirect:/app";
    }

    @RequestMapping(value = "/logout")
    public String logoutSuccess() {
        String message = "Logout Success!";
        return "redirect:/login";
    }
}
