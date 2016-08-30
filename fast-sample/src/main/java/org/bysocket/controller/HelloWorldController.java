package org.bysocket.controller;

import org.bysocket.entity.User;
import org.fastframework.mvc.annotation.Controller;
import org.fastframework.mvc.annotation.MediaTypes;
import org.fastframework.mvc.annotation.RequestMapping;
import org.fastframework.mvc.annotation.RequestMethod;

@Controller
public class HelloWorldController {

    /**
     * GET http://localhost:8080/hello?name=BYSocket
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello",
        method = RequestMethod.GET,
        produces = MediaTypes.TEXT_PLAIN_UTF_8)
    public String hello(String name) {
        return "Hello," + name + "!";
    }

    /**
     * GET http://localhost:8080/user/hello?name=BYSocket&age=23
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/user/hello",
        method = RequestMethod.GET,
        produces = MediaTypes.TEXT_PLAIN_UTF_8)
    public String helloUser(String name, Integer age) {
        User user = new User();
        user.setName(name);
        return "Hello," + name + "!" + age;
    }


}
