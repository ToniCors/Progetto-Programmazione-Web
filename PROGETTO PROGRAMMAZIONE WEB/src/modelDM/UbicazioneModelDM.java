package modelDM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import oggetti.Ubicazione;


public class UbicazioneModelDM {

	private static final String TABELLA_UBICAZIONE = "UBICAZIONE";
	
	
	public synchronized void doSave(Ubicazione ubicazione) throws SQLException {
        System.out.println("tentato salvataggio");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + UbicazioneModelDM.TABELLA_UBICAZIONE
		+ " (Proiezione, Sala) "
		+ "VALUES (?, ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
		
			preparedStatement.setInt(1, ubicazione.getProiezione());
			preparedStatement.setString(2, ubicazione.getSala());
		

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

	
	public synchronized Ubicazione doRetrieveByKey(int proiezione, String sala) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Ubicazione ubicazione = new Ubicazione();

		String selectSQL = "SELECT * FROM " + UbicazioneModelDM.TABELLA_UBICAZIONE 
				+ " WHERE proiezione = ? and sala = ? ";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, proiezione);
			preparedStatement.setString(2, sala);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
		
				ubicazione.setProiezione(rs.getInt("proiezione"));
				ubicazione.setSala(rs.getString("sala"));
				
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		if(ubicazione.getSala()==null || ubicazione.getProiezione()==0 )
			return null;
		else		
		return ubicazione ;
	}
	
	public synchronized Ubicazione doRetrieveByProiezione(int proiezione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Ubicazione ubicazione = new Ubicazione();

		String selectSQL = "SELECT * FROM " + UbicazioneModelDM.TABELLA_UBICAZIONE 
				+ " WHERE proiezione = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, proiezione);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
		
				ubicazione.setProiezione(rs.getInt("proiezione"));
				ubicazione.setSala(rs.getString("sala"));
				
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		if(ubicazione.getSala()==null || ubicazione.getProiezione()==0 )
			return null;
		else		
		return ubicazione ;
	}
	
	public synchronized Ubicazione doRetrieveBySala(String sala) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Ubicazione ubicazione = new Ubicazione();

		String selectSQL = "SELECT * FROM " + UbicazioneModelDM.TABELLA_UBICAZIONE 
				+ " WHERE  sala = ? ";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, sala);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
		
				ubicazione.setProiezione(rs.getInt("proiezione"));
				ubicazione.setSala(rs.getString("sala"));
				
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		if(ubicazione.getSala()==null || ubicazione.getProiezione()==0 )
			return null;
		else		
		return ubicazione ;
	}


	public synchronized Collection<Ubicazione> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Ubicazione> ubicazioni = new LinkedList<Ubicazione>();

		String selectSQL = "SELECT * FROM " + UbicazioneModelDM.TABELLA_UBICAZIONE;
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Ubicazione ubicazione = new Ubicazione();
				
				ubicazione.setProiezione(rs.getInt("proiezione"));
				ubicazione.setSala(rs.getString("sala"));
				

				ubicazioni.add(ubicazione);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return ubicazioni;
	}

	
	public synchronized Collection<Ubicazione> doRetrieveAllByProiezione(int proiezione) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Ubicazione> ubicazioni = new LinkedList<Ubicazione>();

		String selectSQL = "SELECT * FROM " + UbicazioneModelDM.TABELLA_UBICAZIONE
				+ " WHERE proiezione = ? ";
		
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, proiezione);
		

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Ubicazione ubicazione = new Ubicazione();
				
				ubicazione.setProiezione(rs.getInt("proiezione"));
				ubicazione.setSala(rs.getString("sala"));
				

				ubicazioni.add(ubicazione);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return ubicazioni;
		
	}
	
    public synchronized Collection<Ubicazione> doRetrieveAllBySala(String sala) throws SQLException {
		
    	Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Ubicazione> ubicazioni = new LinkedList<Ubicazione>();

		String selectSQL = "SELECT * FROM " + UbicazioneModelDM.TABELLA_UBICAZIONE
				+ " WHERE sala = ? ";
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, sala);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Ubicazione ubicazione = new Ubicazione();
				
				ubicazione.setProiezione(rs.getInt("proiezione"));
				ubicazione.setSala(rs.getString("sala"));
				

				ubicazioni.add(ubicazione);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return ubicazioni;
		
	}
	
}