package org.bysocket.controller;

import org.bysocket.entity.User;
import org.fastframework.mvc.annotation.*;

@Controller
public class RestfulJSONController {

    /**
     * GET http://localhost:8080/json?name=BYSocket
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/json",
        method = RequestMethod.GET,
        produces = MediaTypes.JSON_UTF_8)
    public User json(String name) {
        User user = new User();
        user.setName(name);
        user.setAge(23);
        return user;
    }

    /**
     * GET http://localhost:8080/user/get?name=BYSocket&age=23
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/user/get",
        method = RequestMethod.GET,
        produces = MediaTypes.JSON_UTF_8)
    public User getUser(String name, Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    /**
     * POST http://localhost:8080/user/add
     * Content-Type: application/json
     * {
     * "name":"BYSocket",
     * "age":23
     * }
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/add",
        method = RequestMethod.POST,
        produces = MediaTypes.JSON_UTF_8)
    public User addUser(@PostParam User user) {
        user.setDesc("Blog: http://www.bysocket.com https://github.com/JeffLi1993");
        return user;
    }
}
