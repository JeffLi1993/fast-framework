package org.bysocket.controller;

import org.bysocket.entity.User;
import org.fastframework.mvc.annotation.Controller;
import org.fastframework.mvc.annotation.MediaTypes;
import org.fastframework.mvc.annotation.PostParam;
import org.fastframework.mvc.annotation.RequestMapping;
import org.fastframework.mvc.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@RequestMapping(value = "/hello",
			method = RequestMethod.GET,
			produces = MediaTypes.TEXT_PLAIN_UTF_8)
	public String hello(String name) {
		return "Hello," + name + "!";
	}

	@RequestMapping(value = "/hellobysocket",
			method = RequestMethod.GET,
			produces = MediaTypes.TEXT_PLAIN_UTF_8)
	public String hellobysocket(String name, Integer age) {
		User user = new User();
		user.setName(name);
		return "Hello," + name + "!" + age;
	}


	@RequestMapping(value = "/postexample",
			method = RequestMethod.POST,
			produces = MediaTypes.TEXT_PLAIN_UTF_8)
	public String postexample(@PostParam User user) {
		return user==null? "user is null!!!!" : "Hello," + user.getName() + "!";
	}

}
