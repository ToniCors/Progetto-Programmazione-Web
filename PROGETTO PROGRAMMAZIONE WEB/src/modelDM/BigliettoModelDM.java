package modelDM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import oggetti.Biglietto;


public class BigliettoModelDM {

	private static final String TABELLA_BIGLIETTO = "BIGLIETTO";
	
	
	public synchronized void doSave(Biglietto biglietto) throws SQLException {
        System.out.println("tentato salvataggio");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + BigliettoModelDM.TABELLA_BIGLIETTO
		+ " (IDbiglietto, prezzo, dataAcquisto, oraAcquisto, posto, cliente, proiezione) "
		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
		
			preparedStatement.setString(1, biglietto.getBiglietto());
			preparedStatement.setDouble(2, biglietto.getPrezzoFinale());
			preparedStatement.setString(3, biglietto.getDataAcquistoStr());
			preparedStatement.setString(4, biglietto.getOraAcquistoStr());
			preparedStatement.setInt(5, biglietto.getPosto());
			preparedStatement.setString(6, biglietto.getCliente());
			preparedStatement.setInt(7, biglietto.getProiezione());
			

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

	
	public synchronized Biglietto doRetrieveByKey(String b) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        String data;
        String ora;
		Biglietto biglietto = new Biglietto();

		String selectSQL = "SELECT * FROM " + BigliettoModelDM.TABELLA_BIGLIETTO + " WHERE IDbiglietto = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, b);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
		
				biglietto.setBiglietto(rs.getString("IDbiglietto"));
				biglietto.setPrezzoFinale(rs.getInt("prezzo"));
				data=rs.getString("dataAcquisto");
				ora=rs.getString("oraAcquisto");
				System.out.println("rs= "+data+"  "+ora );
				biglietto.setDataOra(data, ora);
				biglietto.setPosto(rs.getInt("posto"));
				biglietto.setCliente(rs.getString("cliente"));
				biglietto.setProiezione(rs.getInt("proiezione"));
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		if(biglietto.getBiglietto()==null)
			return null;
		else  		
		return biglietto ;
	}
	
	
	public synchronized boolean doDelete(String b) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + BigliettoModelDM.TABELLA_BIGLIETTO + " WHERE IDbiglietto = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, b);

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


	public synchronized Collection<Biglietto> doRetrieveAll(String user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Biglietto> biglietti = new LinkedList<Biglietto>();

		String selectSQL = "SELECT * FROM " + BigliettoModelDM.TABELLA_BIGLIETTO+ " WHERE cliente = ?";
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, user);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Biglietto biglietto = new Biglietto();
				String data;
		        String ora;
				biglietto.setBiglietto(rs.getString("IDbiglietto"));
				biglietto.setPrezzoFinale(rs.getInt("prezzo"));
				data=rs.getString("dataAcquisto");
				ora=rs.getString("oraAcquisto");
				biglietto.setDataOra(data, ora);
				biglietto.setPosto(rs.getInt("posto"));
				biglietto.setCliente(rs.getString("cliente"));
				biglietto.setProiezione(rs.getInt("proiezione"));
				

				biglietti.add(biglietto);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return biglietti;
	}
	
	
	public synchronized ArrayList<Biglietto> doRetrieveByProiezione(String idP) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();

		String selectSQL = "SELECT * FROM " + BigliettoModelDM.TABELLA_BIGLIETTO+ " WHERE proiezione = ?";
				
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, idP);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Biglietto biglietto = new Biglietto();
				String data;
		        String ora;
				biglietto.setBiglietto(rs.getString("IDbiglietto"));
				biglietto.setPrezzoFinale(rs.getInt("prezzo"));
				data=rs.getString("dataAcquisto");
				ora=rs.getString("oraAcquisto");
				biglietto.setDataOra(data, ora);
				biglietto.setPosto(rs.getInt("posto"));
				biglietto.setCliente(rs.getString("cliente"));
				biglietto.setProiezione(rs.getInt("proiezione"));
				

				biglietti.add(biglietto);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return biglietti;
	}
	
	public synchronized ArrayList<Biglietto> doRetrieveByCliente(String idC) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();

		String selectSQL = "SELECT * FROM " + BigliettoModelDM.TABELLA_BIGLIETTO+ " WHERE cliente = ? "
				+ " order by dataAcquisto,oraAcquisto DESC;";
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, idC);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Biglietto biglietto = new Biglietto();
				String data;
		        String ora;
				biglietto.setBiglietto(rs.getString("IDbiglietto"));
				biglietto.setPrezzoFinale(rs.getInt("prezzo"));
				data=rs.getString("dataAcquisto");
				ora=rs.getString("oraAcquisto");
				biglietto.setDataOra(data, ora);
				biglietto.setPosto(rs.getInt("posto"));
				biglietto.setCliente(rs.getString("cliente"));
				biglietto.setProiezione(rs.getInt("proiezione"));
				

				biglietti.add(biglietto);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return biglietti;
	}
	
	

	
}