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
import projet.view.benevoles.ModelBenevoles;


public class DaoBenevoles {

	// Champs

	@Inject
	private DataSource dataSource;

	public List<Benevoles> listerTout() {

		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM benevole ORDER BY nom";
			stmt = cn.prepareStatement(sql);
			rs = stmt.executeQuery();

			List<Benevoles> benevoles = new LinkedList<>();
			while (rs.next()) {
				benevoles.add(construireBenevoles(rs, false));
			}
			return benevoles;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(rs, stmt, cn);
		}
	}

	public Benevoles lister() {

		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM benevole WHERE id_benevole=1";
			stmt = cn.prepareStatement(sql);
			//stmt.setObject(1, idbenevole);
			rs = stmt.executeQuery();
			Benevoles benevole=new Benevoles();
			while (rs.next()) {
				benevole=construireBenevoles(rs, false);
			}
			return benevole;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(rs, stmt, cn);
		}
	}

	private Benevoles construireBenevoles(ResultSet rs, boolean flagComplet) throws SQLException {
		Benevoles benevole = new Benevoles();
		benevole.setId(rs.getObject("id_utilisateur", Integer.class));
		benevole.setNom(rs.getObject("nom", String.class));
		benevole.setPrenom(rs.getObject("prenom", String.class));
		benevole.setPermis(rs.getObject("permis", Boolean.class));
		benevole.setMajeur(rs.getObject("majeur", Boolean.class));
		benevole.setTelephone(rs.getObject("telephone", Integer.class));
		return benevole;
	}

	public void modifier(Benevoles benevole) {
		Connection cn = null;
		PreparedStatement stmt = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE memo SET nom = ?, prenom = ?, permis = ?, majeur = ?, mail = ?, telephone = ?WHERE idbenevoles =  ?";
			stmt = cn.prepareStatement(sql);
			stmt.setObject(1, benevole.getNom());
			stmt.setObject(2, benevole.getPrenom());
			stmt.setObject(3, benevole.getPermis());
			stmt.setObject(4, benevole.getMajeur());
			stmt.setObject(5, benevole.getMail());
			stmt.setObject(6, benevole.getTelephone());
			stmt.setObject(7, benevole.getId());
			stmt.executeUpdate();

			supprimer(benevole.getId());
			inserer(benevole);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(stmt, cn);
		}
	}

	private void supprimer(int idBenevoles) {

		Connection cn = null;
		PreparedStatement stmt = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM concerner WHERE idbenevole = ? ";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, idBenevoles);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(stmt, cn);
		}
	}

	private void inserer(Benevoles benevole) {

		Connection cn = null;
		PreparedStatement stmt = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO concerner ( idbenevole, idpersonne ) VALUES( ?, ? ) ";
			stmt = cn.prepareStatement(sql);
/*
			for (Personne personne : benevole.getPersonnes()) {
				stmt.setObject(1, benevole.getId());
				stmt.setObject(2, personne.getId());
				stmt.executeUpdate();
			}
*/
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(stmt, cn);
		}
	}

	public Benevoles retrouverBenevoles(int idBenevoles){

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM benevole WHERE id_benevole = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1,idBenevoles);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return construireBenevoles(rs, true);
			}else {
				return null;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}

	}
}
