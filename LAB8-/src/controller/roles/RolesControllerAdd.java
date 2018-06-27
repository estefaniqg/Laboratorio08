package controller.roles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import controller.users.PMF;
import model.entity.*;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@SuppressWarnings("serial")
public class RolesControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");


		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();

		

			try {
				req.getRequestDispatcher("/WEB-INF/Views/Roles/add.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
	
		
	


	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String name = req.getParameter("nombre");


		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			Query query = pm.newQuery(Role.class);
			query.setFilter("nombre == idParam");
			query.declareParameters("String idParam");
			List<Role> cantidadRoles = (List<Role>)query.execute(name);


			if(cantidadRoles.size() > 0 ){
				resp.sendRedirect("/role/insertar");
			}
			else {
				Date date = new Date();
				Role role = new Role(name,date,true);
				pm.makePersistent(role);
				resp.getWriter().print("INSERT");
			}
			query.closeAll();
		}
		finally{
			pm.close();
		}
	}
}
	