package org.bysocket.controller;

import org.bysocket.entity.User;
import org.fastframework.mvc.annotation.Controller;
import org.fastframework.mvc.annotation.MediaTypes;
import org.fastframework.mvc.annotation.RequestMapping;
import org.fastframework.mvc.annotation.RequestMethod;

@Controller
public class JSONController {

    @RequestMapping(value = "/json",
        method = RequestMethod.GET,
        produces = MediaTypes.JSON_UTF_8)
    public User json(String name) {
        User user = new User();
        user.setName(name);
        user.setAge(23);
        return user;
    }

    @RequestMapping(value = "/jsonbysocket",
        method = RequestMethod.GET,
        produces = MediaTypes.JSON_UTF_8)
    public User json(String name, Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
