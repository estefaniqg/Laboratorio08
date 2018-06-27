package controller.access;

	import java.io.IOException;


	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.http.*;

	import com.google.appengine.api.users.User;
	import com.google.appengine.api.users.UserService;
	import com.google.appengine.api.users.UserServiceFactory;

	import controller.users.PMF;
	import model.entity.Access;
	
	import model.entity.Resource;
	import model.entity.Usuario;

	import javax.jdo.PersistenceManager;
	import javax.jdo.Query;

	@SuppressWarnings("serial")
	public class AccessControllerDelete extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			resp.setContentType("text/html");

			UserService us = UserServiceFactory.getUserService();
			User user = us.getCurrentUser();

			

				String id = req.getParameter("id");
				Long idLong = Long.parseLong(id);
				PersistenceManager pm = PMF.get().getPersistenceManager();

				try{
					Access acceso = pm.getObjectById(Access.class,idLong);
					pm.deletePersistent(acceso);
				}
				finally{
					pm.close();
				}
				resp.sendRedirect("/access");}
			
		}
