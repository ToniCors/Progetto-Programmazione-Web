package modelDM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import oggetti.Sala;


public class SalaModelDM {

	private static final String TABELLA_SALA = "SALA";
	
	
	public synchronized void doSave(Sala sala) throws SQLException {
        System.out.println("tentato salvataggio");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + SalaModelDM.TABELLA_SALA
		+ " (IDsala, numeroPosti) "
		+ "VALUES (?, ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
		
			preparedStatement.setString(1, sala.getSala());
			preparedStatement.setInt(2, sala.getNumPosti());
			

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

	
	public synchronized Sala doRetrieveByKey(String s) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Sala sala = new Sala();

		String selectSQL = "SELECT * FROM " + SalaModelDM.TABELLA_SALA + " WHERE IDsala = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, s);

			ResultSet rs = preparedStatement.executeQuery();					

			while (rs.next()) {
						
				sala.setSala(rs.getString("IDsala"));
				sala.setNumPosti(rs.getInt("numeroPosti"));			
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		if(sala.getSala()==null)
			return null;
		else  return sala ;
	}
	
	
	
	public synchronized Sala doRetrieveByProiezione(int proiezione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Sala sala = new Sala();

		String selectSQL = "SELECT s.* FROM sala s , ubicazione u, proiezione p"+ " WHERE s.IDsala = u.sala and u.proiezione = p.idproiezione and idproiezione = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, proiezione);

			ResultSet rs = preparedStatement.executeQuery();					

			while (rs.next()) {
						
				sala.setSala(rs.getString("IDsala"));
				sala.setNumPosti(rs.getInt("numeroPosti"));			
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		if(sala.getSala()==null)
			return null;
		else  return sala ;
	}
	
	
	public synchronized boolean doDelete(String sala) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + SalaModelDM.TABELLA_SALA + " WHERE IDsala = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, sala);

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


	public synchronized Collection<Sala> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Sala> sale = new LinkedList<Sala>();

		String selectSQL = "SELECT * FROM " + SalaModelDM.TABELLA_SALA;
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Sala sala = new Sala();
				
				sala.setSala(rs.getString("IDsala"));
				sala.setNumPosti(rs.getInt("numeroPosti"));

				sale.add(sala);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return sale;
	}

	
}