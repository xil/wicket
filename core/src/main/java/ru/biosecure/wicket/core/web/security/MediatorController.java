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
    @ResponseBody
    public String getTemplate() {
        String template = "<div>" +
                "<div id=\"appLayout\" data-dojo-type=\"dijit/layout/LayoutContainer\" data-dojo-attach-point=\"mainLayout\" data-dojo-props=\"design:'headline'\">\n" +
                "    <div data-dojo-type=\"dijit/layout/ContentPane\" data-dojo-attach-point=\"menu\" data-dojo-props=\"region:'top'\"></div>\n" +
                "    <div data-dojo-type=\"dijit/layout/ContentPane\" data-dojo-attach-point=\"mainArea\"\n" +
                "         data-dojo-props=\"region: 'center'\"></div>\n" +
                "</div></div>";
        return template;
    }
}
