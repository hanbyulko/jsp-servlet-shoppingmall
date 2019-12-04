package nmm.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import nmm.controller.Controller;

/**
 * Application Lifecycle Listener implementation class HandlerMappingListener
 *
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext application = sce.getServletContext();
		
		String servlet = application.getContextPath()+"/servlet?controller=";
		application.setAttribute("servlet", servlet);
		String imgPath = application.getContextPath()+"/images/";
		
		application.setAttribute("imgPath", imgPath);
		
		String fileName = application.getInitParameter("fileName");
		Map<String, Controller> map = new HashMap<String, Controller>();
		Map<String, Class<?>> classMap = new HashMap<>();
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		Set<String> keys = rb.keySet();
		try {
			for(String key : keys) {
				String value = rb.getString(key);
				Controller con = 
						(Controller)Class.forName(value).newInstance();
				Class<?> cls = con.getClass();
				map.put(key, con);
				classMap.put(key, cls);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		application.setAttribute("map", map);
		application.setAttribute("classMap", classMap);
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	
}
