package org.fastframework;

import org.fastframework.mvc.annotation.Controller;
import org.fastframework.mvc.annotation.RequestMapping;
import org.fastframework.mvc.annotation.MediaTypes;
import org.fastframework.mvc.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaTypes.TEXT_PLAIN_UTF_8)
	public String hello() {
		return "Hello,World!";
	}

}
