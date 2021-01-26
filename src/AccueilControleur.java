

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccueilControleur
 */
@WebServlet("/AccueilControleur")
public class AccueilControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String message = "";
       
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
		doGet(request, response);
		
		UtilisateurDAOModele utilisateurDAO = new UtilisateurDAOModele();	
		
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		int id = utilisateurDAO.verifier(login, password);
		 
		if (id==-1) {
			System.out.println("Utilisateur non trouvé");
		}
		else {
			System.out.println("Connexion...");
			UtilisateurBeanModele utilisateur = utilisateurDAO.lire(id);
			if (utilisateur.getPoste().equals("operateur")) {
				
				System.out.println("Tu es un opérateur");
							
			}
			else if (utilisateur.getPoste().equals("controleur financier")) {
				
				System.out.println("Tu es un controleur financier");
				
			}
			else if (utilisateur.getPoste().equals("technicien de maintenance")) {
				
				System.out.println("Tu es un technicien de maintenance");
				
			}
			else if (utilisateur.getPoste().equals("responsable")) {
				
				System.out.println("Tu es un responsable");
				
			}
		}
	}

}
