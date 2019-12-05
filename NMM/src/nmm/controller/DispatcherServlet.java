package nmm.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nmm.dto.ModelAndView;

@WebServlet(urlPatterns = { "/servlet" }, loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Controller> map;
	Map<String, Class<?>> classMap;

	@Override
	public void init() throws ServletException {
		map = (Map<String, Controller>) super.getServletContext().getAttribute("map");
		classMap = (Map<String, Class<?>>) super.getServletContext().getAttribute("classMap");
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String controller = request.getParameter("controller");
		String command = request.getParameter("command");
		System.out.println(controller);
		if (controller == null || controller.equals(""))
			controller = "product";

		ModelAndView mv = null;
		try {
			if (!controller.contains(" ")) {
				Controller con = map.get(controller);
				Class<?> cls = classMap.get(controller);
				Method method = cls.getMethod(command, HttpServletRequest.class, HttpServletResponse.class);

				mv = (ModelAndView) method.invoke(con, request, response);
			} else {
				String[] controllerArr = controller.split(" ");
				for (int i = 0; i < controllerArr.length; i++) {
					Controller con = map.get(controllerArr[i]);
					Class<?> cls = classMap.get(controllerArr[i]);
					System.out.println(command);
					Method method = cls.getMethod(command, HttpServletRequest.class, HttpServletResponse.class);
					mv = (ModelAndView) method.invoke(con, request, response);
				}
			}
			if (mv.isRedirect()) {// redirect방식
				response.sendRedirect(mv.getViewName());
			} else {// forward 방식
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("view/error.jsp").forward(request, response);
		}

	}

}
