package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Participants;


public class DaoParticipant {

	@Inject
	private DataSource		dataSource;

	public List<Participants> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM participant ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Participants> participants = new LinkedList<>();
			while (rs.next()) {
				participants.add( construireParticipants( rs, false ) );
			}
			return participants;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}

	public List<Participants> listerInscrits(){
		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM participant WHERE inscription_ok IS TRUE ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Participants> participants = new LinkedList<>();
			while (rs.next()) {
				participants.add( construireParticipants( rs, false ) );
			}
			return participants;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}

	}

	public List<Participants> listerDemandes(){
		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM participant WHERE inscription_ok IS FALSE ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Participants> participants = new LinkedList<>();
			while (rs.next()) {
				participants.add( construireParticipants( rs, false ) );
			}
			return participants;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}

	}

	public List<Participants> lister(){

		return null;
	}

	public Participants retrouverParticipant(int idParticipant){

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM participant WHERE id_participant = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1,idParticipant);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return construireParticipants(rs, true);
			}else {
				return null;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}

	}



	private Participants construireParticipants(ResultSet rs, boolean flagComplet) throws SQLException {
		Participants participant= new Participants();
		participant.setId( rs.getObject( "id_utilisateur", Integer.class ) );
		participant.setNom( rs.getObject( "nom", String.class ) );
		participant.setPrenom( rs.getObject( "prenom", String.class ) );
		participant.setTelephone( rs.getObject( "telephone", Integer.class ) );
		participant.setAdresse( rs.getObject( "adresse", String.class ) );
		participant.setCp( rs.getObject( "cp", Integer.class ) );
		participant.setVille( rs.getObject( "ville", String.class ) );
		participant.setCertificat( rs.getObject( "certificat_ok", Boolean.class ) );
		participant.setInscription( rs.getObject( "inscription_ok", Boolean.class ) );
		return participant;
	}
}


