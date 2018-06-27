package controller.users;

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
	import model.entity.Usuario;
	import model.entity.Role;
	import model.entity.Resource;
	import model.entity.Access;

	@SuppressWarnings("serial")
	public class UsersControllerIndex  extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			resp.setContentType("text/html");




				PersistenceManager pm = PMF.get().getPersistenceManager();
				Query query = pm.newQuery(Usuario.class);

				//query.setOrdering("nombre descending");
				List<Usuario> array = (List<Usuario>)query.execute("select from Usuario");
				List<Role> arrayRol = new ArrayList<Role>();

				for(Usuario usuario:array){
					Role rol = pm.getObjectById(Role.class,usuario.getIdRol());
					arrayRol.add(rol);
				}

				req.setAttribute("array", array);
				req.setAttribute("arrayRol", arrayRol);
				try {
					req.getRequestDispatcher("/WEB-INF/Views/Users/index.jsp").forward(req, resp);
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