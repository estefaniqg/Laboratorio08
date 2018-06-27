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

import model.entity.Role;
import model.entity.Usuario;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@SuppressWarnings("serial")
public class ResourcesControllerAdd  extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");


		

			try {
				req.getRequestDispatcher("/WEB-INF/Views/Resources/add.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String url = req.getParameter("url");


		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			Query query = pm.newQuery(Resource.class);
			query.setFilter("url == idParam");
			query.declareParameters("String idParam");

			List<Resource> arrayRecurso = (List<Resource>)query.execute(url);


			if(arrayRecurso.size() > 0 ){
				resp.getWriter().print("REPEATED");
			}
			else {
				Date fecha = new Date();
				Resource rec = new Resource(url,fecha,true);
				pm.makePersistent(rec);
				resp.getWriter().print("INSERT");
			}
			query.closeAll();
		}
		finally{
			pm.close();
		}
	}
	
}
