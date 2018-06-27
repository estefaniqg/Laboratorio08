package controller.roles;


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
	import model.entity.Role;
	import model.entity.Usuario;

	@SuppressWarnings("serial")
	public class RolesControllerIndex extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			

				PersistenceManager pm = PMF.get().getPersistenceManager();
				Query query = pm.newQuery(Role.class);
				//query.setOrdering("nombre descending");
				List<Role> array = (List<Role>)query.execute("select from Role");

				req.setAttribute("roles", array);
				try {
					req.getRequestDispatcher("/WEB-INF/Views/Roles/index.jsp").forward(req, resp);
					query.closeAll();

				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					pm.close();
				}
		}
		

	}