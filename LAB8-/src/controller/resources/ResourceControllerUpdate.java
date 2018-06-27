package controller.resources;

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
	import model.entity.Usuario;

	import javax.jdo.PersistenceManager;
	import javax.jdo.Query;

	@SuppressWarnings("serial")
	public class ResourceControllerUpdate  extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			resp.setContentType("text/html");

			

				PersistenceManager pm = PMF.get().getPersistenceManager();

				try {		
					String id = req.getParameter("id");
					Long idLong = Long.parseLong(id); 
					Resource rec = pm.getObjectById(Resource.class,idLong);
					req.setAttribute("resource",rec);
					req.getRequestDispatcher("/WEB-INF/Views/Resources/update.jsp").forward(req, resp);

				} catch (Exception e) {
					e.printStackTrace();
				}
				finally{
					pm.close();
				}}
			
			
		

		
	}
