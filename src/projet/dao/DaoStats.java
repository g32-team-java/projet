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


public class DaoStats {

	@Inject
	private DataSource		dataSource;

	
	
	public int listerNbRepas() {
		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT SUM(nombre_repas) AS NbRepas FROM equipe WHERE etat_inscription IS TRUE";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();
			
			if(rs.next()) 
				return (rs.getInt("NbRepas"));
			else
				return (Integer) null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
		
	}
	
	public int listerNbCanoe() {
		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "select  Count(id_equipe) as Nbcanoe from equipe WHERE etat_inscription IS TRUE";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();
			if(rs.next()) 
				return (rs.getInt("Nbcanoe")*2);
			else
				return (Integer) null;
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
		
	}

}


