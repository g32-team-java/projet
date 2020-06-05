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
	private DataSource dataSource;

	public List<Benevoles> listerTout() {

		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM benevole ORDER BY id_benevole";
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

	public Benevoles lister(int idbenevole) {

		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM benevole WHERE id_benevole = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setObject(1, idbenevole);
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
		benevole.setId(rs.getObject("id_benevole", Integer.class));
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
			sql = "UPDATE benevole SET telephone = ?WHERE id_benevole =  ?";
			stmt = cn.prepareStatement(sql);
			stmt.setObject(2, benevole.getTelephone());
			stmt.setObject(3, benevole.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(stmt, cn);
		}
	}

	public void supprimer(int idBenevole) {

		Connection cn = null;
		PreparedStatement stmt = null;
		String sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM avoir WHERE id_benevole = ? ";
			stmt = cn.prepareStatement(sql);
			stmt.setObject(1, idBenevole);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(stmt, cn);
		}
		
		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM benevole WHERE id_benevole = ? ";
			stmt = cn.prepareStatement(sql);
			stmt.setObject(1, idBenevole);
			stmt.executeUpdate();

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
