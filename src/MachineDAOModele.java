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

public class MachineDAOModele {

	public List<MachineBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<MachineBeanModele> machineListe = new ArrayList<MachineBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom, etat, derniereMaintenance, prochaineMaintenance FROM machine;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				MachineBeanModele machine = new MachineBeanModele();
				machine.setId(rs.getInt("id"));
				machine.setNom(rs.getString("nom"));
				machine.setEtat(rs.getInt("etat"));
				machine.setDerniereMaintenance(rs.getTimestamp("derniereMaintenance").toLocalDateTime().toLocalDate());
				machine.setProchaineMaintenance(rs.getTimestamp("prochaineMaintenance").toLocalDateTime().toLocalDate());	

				machineListe.add(machine);
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
		return machineListe;
	}

	public MachineBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		MachineBeanModele machine = new MachineBeanModele();
		try
		{
			String requete = new String("SELECT id, nom, etat, derniereMaintenance, prochaineMaintenance FROM machine WHERE id=?;");
			PreparedStatement statement = connexion.prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if ( rs.next() )
			{

				machine.setId(rs.getInt("id"));
				machine.setNom(rs.getString("nom"));
				machine.setEtat(rs.getInt("etat"));
				machine.setDerniereMaintenance(rs.getTimestamp("derniereMaintenance").toLocalDateTime().toLocalDate());
				machine.setProchaineMaintenance(rs.getTimestamp("prochaineMaintenance").toLocalDateTime().toLocalDate());
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

		return machine;
	}

}
