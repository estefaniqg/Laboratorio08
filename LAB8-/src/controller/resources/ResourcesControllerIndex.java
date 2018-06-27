package controller.resources;

	import java.io.IOException;

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
	import model.entity.Usuario;

	@SuppressWarnings("serial")
	public class ResourcesControllerIndex extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			resp.setContentType("text/html");

			

				PersistenceManager pm = PMF.get().getPersistenceManager();
				Query query = pm.newQuery(Resource.class);
				//query.setOrdering("nombre descending");
				List<Resource> resource = (List<Resource>)query.execute("select from Recurso");

				req.setAttribute("resource", resource);
				try {
					req.getRequestDispatcher("/WEB-INF/Views/Resources/index.jsp").forward(req, resp);
					query.closeAll();

				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					pm.close();
				}}
			
		
	}