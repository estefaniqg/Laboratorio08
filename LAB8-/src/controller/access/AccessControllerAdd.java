package controller.access;

import java.io.IOException;
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
public class AccessControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");


			
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Query query = pm.newQuery(Role.class);
			List<Role> listaRoles = (List<Role>)query.execute("select from Role");

			Query query1 = pm.newQuery(Resource.class);
			//query.setOrdering("nombre descending");
			List<Resource> listaRecurso = (List<Resource>)query1.execute("select from Recurso");


			try {
				req.setAttribute("listaRoles",listaRoles);
				req.setAttribute("listaRecurso",listaRecurso);
				req.getRequestDispatcher("/WEB-INF/Views/Access/add.jsp").forward(req, resp);

				query.closeAll();
				query1.closeAll();

			} catch (ServletException e) {
				System.out.println("Error");
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	

	
}
