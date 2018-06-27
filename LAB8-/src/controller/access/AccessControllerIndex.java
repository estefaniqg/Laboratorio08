package controller.access;

	import java.io.IOException;


	import java.util.ArrayList;
	import java.util.List;

	import javax.jdo.PersistenceManager;
	import javax.jdo.Query;
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

	@SuppressWarnings("serial")
	public class AccessControllerIndex extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			resp.setContentType("text/html");

			UserService us = UserServiceFactory.getUserService();
			User user = us.getCurrentUser();

			
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Query query0 = pm.newQuery(Access.class);

				

				try {
					req.getRequestDispatcher("/WEB-INF/Views/Access/index.jsp").forward(req, resp);
					query0.closeAll();

				} catch (ServletException e) {
					// TODO Auto-generated catch block
					System.out.println("Error" + e.toString());
				}
				finally {
					pm.close();
				}}
			
		
	}