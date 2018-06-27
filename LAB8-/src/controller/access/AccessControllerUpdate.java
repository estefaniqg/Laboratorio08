package controller.access;


import java.io.IOException;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import controller.users.PMF;
import model.entity.Access;
import model.entity.Resource;
import model.entity.Role;
import model.entity.Usuario;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@SuppressWarnings("serial")
public class AccessControllerUpdate extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");

		PersistenceManager pm = PMF.get().getPersistenceManager();

		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();

		
			try {

				Query query = pm.newQuery(Role.class);
				List<Role> arrayRole = (List<Role>)query.execute("select from Role");

				Query query1 = pm.newQuery(Resource.class);
				List<Resource> arrayRecurso = (List<Resource>)query1.execute("select from Recurso");

				String id = req.getParameter("id");
				Long idLong = Long.parseLong(id); 

				Access acceso = pm.getObjectById(Access.class,idLong);

				req.setAttribute("acceso",acceso);
				req.setAttribute("arrayRole",arrayRole);
				req.setAttribute("arrayRecurso",arrayRecurso);



				req.getRequestDispatcher("/WEB-INF/Vistas/Acceso/modificar.jsp").forward(req, resp);

				query.closeAll();
				query1.closeAll();
			} catch (Exception e) {
				System.out.println("Error "+e.getMessage());
			}
			finally{
				pm.close();
			}}
		
	

	
}
