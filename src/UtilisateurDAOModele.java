/**
 * 
 * @author t.mureddu
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class UtilisateurDAOModele {

	public List<UtilisateurBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<UtilisateurBeanModele> utilisateurListe = new ArrayList<UtilisateurBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom, prenom, login, mdp, poste FROM utilisateur;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				UtilisateurBeanModele utilisateur = new UtilisateurBeanModele();
				utilisateur.setId(rs.getInt("id"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setMdp(rs.getString("mdp"));
				utilisateur.setPoste(rs.getString("poste"));	

				utilisateurListe.add(utilisateur);
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally 
		{
			connexionBDDModele.fermerConnexion();
		}
		return utilisateurListe;
	}

	public UtilisateurBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		UtilisateurBeanModele utilisateur = new UtilisateurBeanModele();
		try
		{
			String requete = new String("SELECT id, nom, prenom, login, mdp, poste FROM utilisateur WHERE id=?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if ( rs.next() )
			{

				utilisateur.setId(rs.getInt("id"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setLogin(rs.getString("login"));
				utilisateur.setMdp(rs.getString("mdp"));
				utilisateur.setPoste(rs.getString("poste"));
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println("here");
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}

		return utilisateur;
	}

	public int verifier(String login, String password) {


		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		int id = -1;
		try {
			
			String requete = new String("SELECT id FROM utilisateur WHERE login=? AND mdp=MD5(?) ;"); 
			PreparedStatement statement = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1,login);
			statement.setString(2,password);
			ResultSet rs = statement.executeQuery(); 
			
			if ( rs.next() )
			{
				id=rs.getInt("id");
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println("here");
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		connexionBDDModele.fermerConnexion();
		return id;
	}

}
