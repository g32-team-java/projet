package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Poste;

public class DaoPoste {

	@Inject
	private DataSource		dataSource;

	public List<Poste> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM poste ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Poste> postes = new LinkedList<>();
			while (rs.next()) {
				postes.add( construirePoste( rs ) );
			}
			return postes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}

	

	public List<Poste> lister(){

		return null;
	}
	
	public void supprimer( int idPoste ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM poste WHERE id_poste = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, idPoste );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
	
	public Poste retrouver( int idPoste ) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM poste WHERE id_poste = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1, idPoste);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construirePoste(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	public int inserer( Poste poste ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO poste ( nom, nb_poste, majeur, membre,horaire_deb_esti,horaire_fin_esti ) VALUES( ?, ?, ?,?, ?, ? ) ";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, poste.getNom() );
			stmt.setObject( 2, poste.getNbPoste() );
			stmt.setObject( 3, poste.getMajeur() );
			stmt.setObject( 4, poste.getMembre() );
			stmt.setObject(5, poste.getHeure_debut());
			stmt.setObject(6, poste.getHeure_fin());
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			poste.setId( rs.getObject( 1, Integer.class) );
			return poste.getId();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	public void modifier( Poste poste ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE poste SET nom = ?, nb_poste = ?, majeur = ?, membre = ?, horaire_deb_esti= ?, horaire_fin_esti = ? WHERE id_poste =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, poste.getNom() );
			stmt.setObject( 2, poste.getNbPoste() );
			stmt.setObject( 3, poste.getMajeur() );
			stmt.setObject( 4, poste.getMembre() );
			stmt.setObject(5, poste.getHeure_debut());
			stmt.setObject(6, poste.getHeure_fin());
			stmt.setObject(7, poste.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
	
	

	
	private Poste construirePoste(ResultSet rs) throws SQLException {
		Poste poste= new Poste();
		poste.setId( rs.getObject( "id_poste", Integer.class ) );
		poste.setNom( rs.getObject( "nom", String.class ) );
		poste.setNbPoste(rs.getObject("nb_poste", Integer.class));
		poste.setMajeur(rs.getObject("majeur", Boolean.class));
		poste.setMembre(rs.getObject("membre", Boolean.class));
		poste.setHeure_debut(rs.getObject("horaire_deb_esti", LocalTime.class));
		poste.setHeure_fin(rs.getObject("horaire_fin_esti", LocalTime.class));
		return poste;
	}
	
	
}


