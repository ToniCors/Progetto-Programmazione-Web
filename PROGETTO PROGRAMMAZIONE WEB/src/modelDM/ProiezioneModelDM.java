package modelDM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import oggetti.Proiezione;


public class ProiezioneModelDM {

	private static final String TABELLA_PROIEZIONE = "PROIEZIONE";
	
	
	public synchronized void doSave(Proiezione proiezione) throws SQLException {
        System.out.println("tentato salvataggio");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProiezioneModelDM.TABELLA_PROIEZIONE
		+ " (IDproiezione, dataProiezione, fasciaOraria, prezzoBase, _3D, film) "
		+ "VALUES (null, ?, ?, ?, ?, ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
		
			System.out.println(""+proiezione.getDataStr());
			preparedStatement.setString(1, proiezione.getDataStr());
			preparedStatement.setInt(2, proiezione.getFasciaOraria());
			preparedStatement.setDouble(3, proiezione.getPrezzoBase());			
			preparedStatement.setBoolean(4, proiezione.is3D());			
			preparedStatement.setString(5, proiezione.getFilm());
			System.out.println(""+preparedStatement.toString());

			preparedStatement.executeUpdate();
			System.out.println("eseguito");
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		System.out.println("salvato");
	}

	
	public synchronized Proiezione doRetrieveByKey(int idpro) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Proiezione proiezione = new Proiezione();

		String selectSQL = "SELECT * FROM " + ProiezioneModelDM.TABELLA_PROIEZIONE + " WHERE IDproiezione = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idpro);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
		
				proiezione.setIdProiezione(""+rs.getInt("IDproiezione"));
				proiezione.setDataStr(rs.getString("dataProiezione"));
				proiezione.setFasciaOraria(rs.getInt("fasciaOraria"));
				proiezione.setPrezzoBase(rs.getDouble("prezzoBase"));
				proiezione.set3D(rs.getBoolean("_3D"));
				proiezione.setFilm(rs.getString("film"));
				
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		if(proiezione.getIdProiezione()==null)
			return null;
		else  		
		return proiezione ;
	}
	
	
	public synchronized boolean doDelete(int pro) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProiezioneModelDM.TABELLA_PROIEZIONE + " WHERE IDproiezione = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, pro);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}


	public synchronized Collection<Proiezione> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Proiezione> proiezioni = new LinkedList<Proiezione>();

		String selectSQL = "SELECT * FROM " + ProiezioneModelDM.TABELLA_PROIEZIONE;
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Proiezione proiezione = new Proiezione();
				
				proiezione.setIdProiezione(""+rs.getInt("IDproiezione"));
				proiezione.setDataStr(rs.getString("dataProiezione"));
				proiezione.setFasciaOraria(rs.getInt("fasciaOraria"));
				proiezione.setPrezzoBase(rs.getDouble("prezzoBase"));
				proiezione.set3D(rs.getBoolean("_3D"));
				proiezione.setFilm(rs.getString("film"));

				proiezioni.add(proiezione);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return proiezioni;
	}
	
	public synchronized ArrayList<Proiezione> doRetrieveDistinctByDate(String data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Proiezione> proiezioni = new ArrayList<Proiezione>();

		String selectSQL = "SELECT * FROM " + ProiezioneModelDM.TABELLA_PROIEZIONE +
				" where dataProiezione='"+data+"'"+
                  "GROUP BY (film);";
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Proiezione proiezione = new Proiezione();
				
				proiezione.setIdProiezione(""+rs.getInt("IDproiezione"));
				proiezione.setDataStr(rs.getString("dataProiezione"));
				proiezione.setFasciaOraria(rs.getInt("fasciaOraria"));
				proiezione.setPrezzoBase(rs.getDouble("prezzoBase"));
				proiezione.set3D(rs.getBoolean("_3D"));
				proiezione.setFilm(rs.getString("film"));

				proiezioni.add(proiezione);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return proiezioni;
	}
	
public  synchronized void ChangePrezzo(int idpro,double prez) throws SQLException{
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;


		String updateSQL = "UPDATE " + ProiezioneModelDM.TABELLA_PROIEZIONE+ 
				" SET prezzoBase= ?"+
				" WHERE idProiezione = ?";
		
	System.out.println("query "+updateSQL);
		
	try {
		connection = DriverMaagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setDouble(1, prez);
		preparedStatement.setInt(2, idpro);
	


		int rs = preparedStatement.executeUpdate();

	} finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} finally {
			DriverMaagerConnectionPool.releaseConnection(connection);
		}
	}
		
	}
		
		
		
	}

	
