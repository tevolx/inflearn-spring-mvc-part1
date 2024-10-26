package hello.servlet.web.frontcontroller.v1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ControllerV1
 *
 * @author HYUN TAE PARK
 * @version 1.0.0
 * @since 2023. 05. 29.
 */
public interface ControllerV1 {

	void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
