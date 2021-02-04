import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccueilControleur
 */
@WebServlet("/AccueilControleur")
public class AccueilControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */ 
	public AccueilControleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("/AccueilVue.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		UtilisateurDAOModele utilisateurDAO = new UtilisateurDAOModele();
		String message="test";		

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		int id = utilisateurDAO.verifier(login, password);

		if (id==-1) {
			message = "Utilisatrice non trouvé";

			request.setAttribute("message", message);
		}
		else {
			UtilisateurBeanModele utilisateur = utilisateurDAO.lire(id);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("utilisateur", utilisateur);
			
			if (utilisateur.getPoste().equals("operateur")) {

				response.sendRedirect("PointageVue.jsp");		

			}
			else if (utilisateur.getPoste().equals("controleur financier")) {

				response.sendRedirect("PerformancesActuellesVue.jsp");

			}
			else if (utilisateur.getPoste().equals("technicien de maintenance")) {

				response.sendRedirect("PlanningMaintenanceVue.jsp");

			}
			else if (utilisateur.getPoste().equals("responsable")) {

				response.sendRedirect("PerformancesVue.jsp");

			}
		}
	}

}
