package ru.biosecure.wicket.core.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.biosecure.wicket.core.repo.PersonRepository;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.security.User;
import ru.biosecure.wicket.core.repo.UserRepository;
import ru.biosecure.wicket.core.web.SimpleController;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 01.07.13
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/ws/rest/user")
public class UserController implements SimpleController {

    @Inject
    private UserRepository userRepository;
    @Inject
    private PersonRepository personRepository;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> getAll() {
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("id", "id");
        resMap.put("items", personRepository.findAll());
        return resMap;
    }

    @Override
    @RequestMapping("/template")
    @ResponseBody
    public String getScreenTemplate() {
//        return "<div id=\"gridContainer\"></div>";
        return "<div id=\"userBrowserLayout\" data-dojo-type=\"dijit/layout/LayoutContainer\"\n" +
                "     data-dojo-props=\"design:'headline'\">\n" +
                "    <div class=\"${baseClass}Title\" data-dojo-attach-point=\"titleNode\" data-dojo-type=\"dijit.layout.ContentPane\"\n" +
                "         data-dojo-props=\"region:'top'\">\n" +
                "        <button data-dojo-attach-point=\"createButton\" data-dojo-type=\"dijit/form/ToggleButton\">Create</button>\n" +
                "        <button data-dojo-attach-point=\"editButton\" data-dojo-type=\"dijit/form/ToggleButton\">Edit</button>\n" +
                "        <button data-dojo-attach-point=\"removeButton\" data-dojo-type=\"dijit/form/ToggleButton\">Remove</button>\n" +
                "        <button data-dojo-attach-point=\"refreshButton\" data-dojo-type=\"dijit/form/ToggleButton\">Refresh</button>\n" +
                "    </div>\n" +
                "    <div data-dojo-type=\"dijit.layout.ContentPane\" class=\"${baseClass}Container\"\n" +
                "         data-dojo-attach-point=\"containerNode\" data-dojo-props=\"region:'center'\">\n" +
                "        <table id=\"usersGrid\" data-dojo-type=\"dojox.grid.DataGrid\" data-dojo-attach-point=\"usersGrid\"\n" +
                "               data-dogo-id=\"grid\" class=\"grid\" autoHeight=\"15\">\n" +
                "            <thead>\n" +
                "                <tr>\n" +
                "                    <th field=\"id\">Id</th>\n" +
                "                    <th field=\"firstName\">Firstname</th>\n" +
                "                    <th field=\"middlename\">Middlename</th>\n" +
                "                    <th field=\"lastname\">Lastname</th>\n" +
                "                </tr>\n" +
                "            </thead>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</div>\n";
    }

    @RequestMapping("/editTemplate")
    public String getEditTemplate() {
        return "userEdit";
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson(@PathVariable String userId) {
        return personRepository.findOne(Long.parseLong(userId));
    }
}
