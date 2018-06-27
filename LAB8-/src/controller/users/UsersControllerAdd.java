package controller.users;

	import java.io.IOException;

	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.http.*;

	import com.google.appengine.api.users.User;
	import com.google.appengine.api.users.UserService;
	import com.google.appengine.api.users.UserServiceFactory;

	import model.entity.Access;
	import model.entity.Resource;
	import model.entity.Role;
	import model.entity.Usuario;
	import javax.jdo.PersistenceManager;
	import javax.jdo.Query;

	@SuppressWarnings("serial")
	public class UsersControllerAdd  extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			resp.setContentType("text/html");
			
			
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query query = pm.newQuery(Role.class);
			//query.setOrdering("nombre descending");
			
			List<Role> array = (List<Role>)query.execute("select from Role");
			
			req.setAttribute("array", array);
			
			try {
				req.getRequestDispatcher("/WEB-INF/Views/Users/add.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		
		
		
	}
