package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Benevoles;

public class DaoBenevoles {
	
	// Champs

	@Inject
	private DataSource		dataSource;

	public List<Benevoles> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM benevole ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Benevoles> benevoles = new LinkedList<>();
			while (rs.next()) {
				benevoles.add( construireBenevoles( rs, false ) );
			}
			return benevoles;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}

	public List<Benevoles> lister(){
		
		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM benevole WHERE id_benevole=1";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Benevoles> benevoles = new LinkedList<>();
			while (rs.next()) {
				benevoles.add( construireBenevoles( rs, false ) );
			}
			return benevoles;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	private Benevoles construireBenevoles(ResultSet rs, boolean flagComplet) throws SQLException {
		Benevoles benevole= new Benevoles();
		benevole.setId( rs.getObject( "id_utilisateur", Integer.class ) );
		benevole.setNom( rs.getObject( "nom", String.class ) );
		benevole.setPrenom( rs.getObject( "prenom", String.class ) );
		benevole.setPermis( rs.getObject( "permis", Boolean.class ) );
		benevole.setMajeur( rs.getObject( "majeur", Boolean.class ) );
		benevole.setTelephone( rs.getObject( "telephone", Integer.class ) );
		return benevole;
	}
}
