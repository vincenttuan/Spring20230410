package spring.mvc.session17.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

// 自定全局例外異常處理
@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String referer = request.getHeader("Referer");
		ModelAndView mv = new ModelAndView();
		mv.addObject("referer", referer);
		mv.addObject("ex", "Global Exception: " + ex);
		mv.setViewName("session17/error");
		return mv;
	}
	
}
