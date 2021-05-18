package app;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
	
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				return "error404";
			} 
			else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
				model.addAttribute("exception", throwable.getCause().getMessage());
				return "error500";
			}
			else if(statusCode == HttpStatus.BAD_REQUEST.value()) {
				return "error400";
			}
		}
		return "error";
	}
}
