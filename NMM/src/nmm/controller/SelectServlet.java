package nmm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import nmm.dao.UserDAOImpl;
import nmm.dto.UserDTO;

/**
 * Servlet implementation class ListCheckServlet
 */
@WebServlet("/selectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<UserDTO> list = new ArrayList<UserDTO>();
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml; charset=UTF-8");
		UserDAOImpl user = new UserDAOImpl();
		PrintWriter out = response.getWriter();
		try {
		list = user.selectAll(1);
		JSONArray result = JSONArray.fromObject(list);
		out.print(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
