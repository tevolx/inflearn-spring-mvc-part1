package hello.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringMemberFormControllerV1
 *
 * @author HYUN TAE PARK
 * @version 1.0.0
 * @since 2023. 05. 29.
 */

@Controller
public class SpringMemberFormControllerV1 {

	@RequestMapping("/springmvc/v1/members/new-form")
	public ModelAndView process() {
		return new ModelAndView("new-form");
	}
}
