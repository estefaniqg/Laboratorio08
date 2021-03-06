package controller.resources;


	

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
	 public class ResourcesControllerDelete  extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			resp.setContentType("text/html");


			
				String id = req.getParameter("id");
				Long idLong = Long.parseLong(id);
				PersistenceManager pm = PMF.get().getPersistenceManager();

				try{
					Query query = pm.newQuery(Resource.class);
					query.setFilter("id == idParam");
					query.declareParameters("Long idParam");
					query.deletePersistentAll(idLong);
					query.closeAll();
				}
				finally{
					pm.close();
				}
				resp.sendRedirect("/recurso");}
	
	

	}

