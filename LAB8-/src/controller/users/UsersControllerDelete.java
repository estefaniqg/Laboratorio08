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
	import model.entity.Usuario;
	import javax.jdo.PersistenceManager;
	import javax.jdo.Query;

	@SuppressWarnings("serial")
	public class UsersControllerDelete  extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			resp.setContentType("text/html");


			

		

				String codigo = req.getParameter("codigo");
				Long codigoLong = Long.parseLong(codigo);
				PersistenceManager pm = PMF.get().getPersistenceManager();

				try{
					Query query = pm.newQuery(Usuario.class);
					query.setFilter("codigo == codigoParam");
					query.declareParameters("Long codigoParam");
					query.deletePersistentAll(codigoLong);
					query.closeAll();
				}
				finally{
					pm.close();
				}
				resp.sendRedirect("/usuario");
			}
		

	}
